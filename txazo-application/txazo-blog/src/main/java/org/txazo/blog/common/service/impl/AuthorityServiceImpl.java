package org.txazo.blog.common.service.impl;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.txazo.blog.common.enums.PrivilegeType;
import org.txazo.blog.common.service.AuthorityService;
import org.txazo.blog.common.util.LoginUtils;
import org.txazo.blog.common.util.PrivilegeUtils;
import org.txazo.blog.module.login.service.LoginService;
import org.txazo.blog.module.user.bean.User;
import org.txazo.blog.module.user.service.UserService;
import org.txazo.util.web.cookie.CookieUtils;

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

    private static final int COOKIE_MAX_AGE = 1800;

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @Override
    public boolean checkAuthority(HttpServletRequest request, HttpServletResponse response, PrivilegeType privilege) {
        if (request == null || response == null || privilege == null) {
            redirectToNoAccess(response);
            return false;
        }

        /** 无权限限制 */
        if (privilege == PrivilegeType.UNLIMIT) {
            return true;
        }

        int userId = NumberUtils.toInt(CookieUtils.getCookieValue(LoginUtils.COOKIE_USER_ID, request), 0);
        if (userId < 1) {
            redirectToNoAccess(response);
            return false;
        }

        String code = loginService.getLoginCode(userId);
        if (code == null) {
            redirectToNoAccess(response);
            return false;
        }

        String loginKey = CookieUtils.getCookieValue(LoginUtils.COOKIE_LOGIN_KEY, request);
        if (!LoginUtils.generateLoginKey(userId, code).equals(loginKey)) {
            redirectToNoAccess(response);
            return false;
        }

        User user = userService.getUser(userId);
        if ((user != null && PrivilegeUtils.checkPrivilege(privilege.getId(), user.getPrivilege()))) {
            request.setAttribute("user", user);
            return true;
        }

        redirectToNoAccess(response);
        return false;
    }

    private void redirectToNoAccess(HttpServletResponse response) {
        if (response != null) {
            try {
                response.sendRedirect("/error/noaccess");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
