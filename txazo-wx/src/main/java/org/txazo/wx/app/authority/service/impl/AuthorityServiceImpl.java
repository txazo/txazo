package org.txazo.wx.app.authority.service.impl;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.txazo.weixin.WeiXinUtils;
import org.txazo.wx.app.authority.enums.AuthorityType;
import org.txazo.wx.app.authority.service.AuthorityService;
import org.txazo.wx.app.authority.service.UserPermissionService;
import org.txazo.wx.app.common.util.CookieUtils;
import org.txazo.wx.app.common.util.RequestUtils;

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
    private static final String AUTH_CODE_COOKIE = "auth_code";
    private static final String AUTH_COUNT_COOKIE = "auth_count";
    private static final int MAX_AUTH_COUNT = 2;

    @Resource
    private Ehcache springEhCache;

    @Autowired
    private UserPermissionService userPermissionService;

    @Override
    public boolean checkAuthority(HttpServletRequest request, HttpServletResponse response, AuthorityType type) {
        if (request == null || response == null || type == null) {
            if (response != null) {
                redirectToNoAccess(response);
            }
            return false;
        }

        if (type == AuthorityType.ALL) {
            return true;
        }

        String sessionId = request.getSession().getId();
        boolean authFlag = false;
        String authCode = CookieUtils.getCookieValue(AUTH_CODE_COOKIE, request);
        int authCount = NumberUtils.toInt(CookieUtils.getCookieValue(AUTH_COUNT_COOKIE, request), 0);
        if (StringUtils.isBlank(authCode) || (authFlag = springEhCache.get(sessionId) == null)) {
            if (authCount >= MAX_AUTH_COUNT) {
                redirectToNoAccess(response);
                return false;
            }

            String code = request.getParameter("code");
            String state = request.getParameter("state");
            String shaCode = DigestUtils.sha1Hex(request.getRequestURI());
            if (shaCode.equals(state)) {
                /** 获取微信用户UserId */
                String userId = WeiXinUtils.getUserId(code);
                if (userPermissionService.checkUserPermission(userId, type)) {
                    springEhCache.put(new Element(sessionId, code));
                    CookieUtils.removeCookie(request, response, AUTH_COUNT_COOKIE);
                    CookieUtils.setCookie(response, AUTH_CODE_COOKIE, code, COOKIE_MAX_AGE);
                    return true;
                }
            }

            /** 重定向到微信OAuth */
            try {
                CookieUtils.removeCookie(request, response, AUTH_CODE_COOKIE);
                CookieUtils.setCookie(response, AUTH_COUNT_COOKIE, String.valueOf(authCount + 1), COOKIE_MAX_AGE);
                WeiXinUtils.redirectToAuth(RequestUtils.getRequestURL(request, "code", "state"), shaCode, response);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }

        Element element = springEhCache.get(sessionId);
        boolean passAuthority = element != null && authCode.equals(element.getObjectValue());
        if (!passAuthority) {
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
