package org.txazo.wx.app.authority.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.txazo.weixin.develop.auth.AuthUtils;
import org.txazo.wx.app.authority.AuthorityType;
import org.txazo.wx.app.authority.service.AuthorityService;
import org.txazo.wx.app.common.util.CookieUtils;
import org.txazo.wx.app.common.util.RequestUtils;

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

    private static final String AUTH_CODE_COOKIE = "auth_code";
    private static final String AUTH_CODE_DEFAULT = "auth_code";

    @Override
    public boolean checkAuthority(HttpServletRequest request, HttpServletResponse response, AuthorityType type) {
        if (request == null || type == null) {
            return false;
        }
        String authCode = CookieUtils.getCookieValue(AUTH_CODE_COOKIE, request);
        System.out.println("Cookie: " + authCode);
        if (StringUtils.isBlank(authCode)) {
            String shaCode = DigestUtils.sha1Hex(request.getRequestURI());

            String code = request.getParameter("code");
            String state = request.getParameter("state");
            System.out.println("code: " + code);
            System.out.println("state: " + state);
            if (shaCode.equals(state)) {
                System.out.println("add Cookie: " + state);
                CookieUtils.setCookie(response, AUTH_CODE_COOKIE, code);
                return true;
            }

            System.out.println("redirectToAuth");
            try {
                CookieUtils.setCookie(response, AUTH_CODE_COOKIE, AUTH_CODE_DEFAULT);
                AuthUtils.redirectToAuth(RequestUtils.getRequestURL(request), shaCode, response);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
        return true;
    }

}
