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
            System.out.println("-----------------: checkAuthority return 1");
            return false;
        }

        /** 无权限限制 */
        if (privilege == PrivilegeType.UNLIMIT) {
            System.out.println("-----------------: checkAuthority return 2");
            return true;
        }

        /** 缓存是否失效 */
        boolean cacheMissed = false;
        /** sessionId */
        String sessionId = request.getSession().getId();
        /** userId */
        int userId = NumberUtils.toInt(CookieUtils.getCookieValue(COOKIE_USER_ID, request), 0);
        /** 登录验证key */
        String loginKey = CookieUtils.getCookieValue(COOKIE_LOGIN_KEY, request);
        /** OAuth验证次数 */
        int authCount = NumberUtils.toInt(CookieUtils.getCookieValue(COOKIE_AUTH_COUNT, request), 0);
        /** 未通过验证或缓存失效 */
        if (userId == 0 || (cacheMissed = springEhCache.get(sessionId) == null)) {
            if (authCount >= MAX_AUTH_COUNT) {
                redirectToNoAccess(response);
                System.out.println("-----------------: checkAuthority return 3");
                return false;
            }

            String code = request.getParameter("code");
            String state = request.getParameter("state");
            String shaCode = DigestUtils.sha1Hex(request.getRequestURI());
            System.out.println("-----------------: checkAuthority code " + code);
            System.out.println("-----------------: checkAuthority state " + state);
            System.out.println("-----------------: checkAuthority shaCode " + shaCode);
            System.out.println("-----------------: checkAuthority url " + RequestUtils.getRequestURL(request));
            if (shaCode.equals(state)) {
                /** 获取微信用户名 */
                String userName = WeiXinUtils.getUserId(code);
                System.out.println("-----------------: checkAuthority userName " + userName);
                /** 查询用户信息 */
                User user = userService.getUser(userName);
                System.out.println("-----------------: checkAuthority user " + (user == null ? "null" : user.getId()));
                /** 用户权限验证 */
                if (user != null && PrivilegeUtils.checkPrivilege(privilege.getId(), user.getPrivilege())) {
                    /** 通过权限验证 */
                    request.setAttribute("user", user);
                    springEhCache.put(new Element(sessionId, code));
                    CookieUtils.removeCookie(request, response, COOKIE_AUTH_COUNT);
                    CookieUtils.setCookie(response, COOKIE_USER_ID, String.valueOf(user.getId()), COOKIE_MAX_AGE);
                    CookieUtils.setCookie(response, COOKIE_LOGIN_KEY, PrivilegeUtils.generateLoginKey(user.getId(), code), COOKIE_MAX_AGE);
                    System.out.println("-----------------: checkAuthority return 4");
                    return true;
                }
            }

            /** 重定向到微信OAuth验证 */
            try {
                CookieUtils.removeCookie(request, response, COOKIE_USER_ID);
                CookieUtils.removeCookie(request, response, COOKIE_LOGIN_KEY);
                CookieUtils.setCookie(response, COOKIE_AUTH_COUNT, String.valueOf(authCount + 1), COOKIE_MAX_AGE);
                WeiXinUtils.redirectToAuth(RequestUtils.getRequestURL(request, "code", "state"), shaCode, response);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("-----------------: checkAuthority return 5");
            return false;
        }

        /** Cookie验证 */
        Element element = springEhCache.get(sessionId);
        boolean passedAuthority = element != null && PrivilegeUtils.generateLoginKey(userId, element.getObjectValue().toString()).equals(loginKey);
        if (passedAuthority) {
            request.setAttribute("user", userService.getUser(userId));
            System.out.println("-----------------: checkAuthority return 6");
        } else {
            System.out.println("-----------------: checkAuthority return 7");
            redirectToNoAccess(response);
        }
        return passedAuthority;
    }

    private void redirectToNoAccess(HttpServletResponse response) {
        try {
            response.sendRedirect("/common/noaccess.wx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
