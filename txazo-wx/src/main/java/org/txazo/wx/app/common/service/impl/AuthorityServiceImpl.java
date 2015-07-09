package org.txazo.wx.app.common.service.impl;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.txazo.util.web.cookie.CookieUtils;
import org.txazo.util.web.servlet.RequestUtils;
import org.txazo.weixin.WeiXinUtils;
import org.txazo.wx.app.common.enums.PrivilegeType;
import org.txazo.wx.app.common.service.AuthorityService;
import org.txazo.wx.app.common.util.PrivilegeUtils;
import org.txazo.wx.app.user.bean.User;
import org.txazo.wx.app.user.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AuthorityServiceImpl
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 30.06.2015
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {

    private static final int COOKIE_MAX_AGE = 600;
    private static final String COOKIE_USER_ID = "user_id";
    private static final String COOKIE_LOGIN_KEY = "login_key";
    private static final String COOKIE_AUTH_COUNT = "auth_count";
    private static final int MAX_AUTH_COUNT = 2;

    @Resource
    private Ehcache springEhCache;

    @Autowired
    private UserService userService;

    @Override
    public boolean checkAuthority(HttpServletRequest request, HttpServletResponse response, PrivilegeType privilege) {
        if (request == null || response == null || privilege == null) {
            if (response != null) {
                redirectToNoAccess(response);
            }
            return false;
        }

        /** 无权限限制 */
        if (privilege == PrivilegeType.UNLIMIT) {
            return true;
        }

        /** 是否OAuth通过验证 */
        boolean oAuthFlag = false;
        /** sessionId */
        String sessionId = request.getSession().getId();
        /** userId */
        int userId = NumberUtils.toInt(CookieUtils.getCookieValue(COOKIE_USER_ID, request), 0);
        /** 登录验证key */
        String loginKey = CookieUtils.getCookieValue(COOKIE_LOGIN_KEY, request);
        /** OAuth验证次数 */
        int authCount = NumberUtils.toInt(CookieUtils.getCookieValue(COOKIE_AUTH_COUNT, request), 0);
        if (userId == 0 || (oAuthFlag = springEhCache.get(sessionId) == null)) {
            if (authCount >= MAX_AUTH_COUNT) {
                redirectToNoAccess(response);
                return false;
            }

            String code = request.getParameter("code");
            String state = request.getParameter("state");
            String shaCode = DigestUtils.sha1Hex(request.getRequestURI());
            if (shaCode.equals(state)) {
                /** 获取微信用户名 */
                String userName = WeiXinUtils.getUserId(code);
                /** 查询user */
                User user = userService.getUser(userName);
                if (user != null && PrivilegeUtils.checkPrivilege(privilege.getId(), user.getPrivilege())) {
                    /** 通过权限验证 */
                    springEhCache.put(new Element(sessionId, code));
                    request.setAttribute("user", user);
                    CookieUtils.removeCookie(request, response, COOKIE_AUTH_COUNT);
                    CookieUtils.setCookie(response, COOKIE_USER_ID, String.valueOf(user.getId()), COOKIE_MAX_AGE);
                    CookieUtils.setCookie(response, COOKIE_LOGIN_KEY, PrivilegeUtils.generateLoginKey(user.getId(), code), COOKIE_MAX_AGE);
                    return true;
                }
            }

            /** 重定向到微信OAuth */
            try {
                CookieUtils.removeCookie(request, response, COOKIE_USER_ID);
                CookieUtils.removeCookie(request, response, COOKIE_LOGIN_KEY);
                CookieUtils.setCookie(response, COOKIE_AUTH_COUNT, String.valueOf(authCount + 1), COOKIE_MAX_AGE);
                WeiXinUtils.redirectToAuth(RequestUtils.getRequestURL(request, "code", "state"), shaCode, response);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }

        Element element = springEhCache.get(sessionId);
        boolean passAuthority = element != null && PrivilegeUtils.generateLoginKey(userId, element.getObjectValue().toString()).equals(loginKey);
        if (passAuthority) {
            request.setAttribute("user", userService.getUser(userId));
        } else {
            redirectToNoAccess(response);
        }
        return passAuthority;
    }

    private void redirectToNoAccess(HttpServletResponse response) {
        try {
            response.sendRedirect("/authority/noaccess.wx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
