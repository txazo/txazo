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
    public boolean checkAuthority(HttpServletRequest request, HttpServletResponse response, PrivilegeType privilege) throws Exception {
        /** 无权限限制 */
        if (privilege == PrivilegeType.UNLIMIT) {
            return true;
        }

        /** 未登录 */
        int userId = NumberUtils.toInt(CookieUtils.getCookieValue(LoginUtils.COOKIE_USER_ID, request), 0);
        if (userId < 1) {
            redirectToLogin(response);
            return false;
        }

        /** 登录超时 */
        String code = loginService.getLoginCode(userId);
        if (code == null) {
            redirectToLogin(response);
            return false;
        }

        /** 未登录 */
        String loginKey = CookieUtils.getCookieValue(LoginUtils.COOKIE_LOGIN_KEY, request);
        if (!LoginUtils.generateLoginKey(userId, code).equals(loginKey)) {
            redirectToLogin(response);
            return false;
        }

        /** 无效用户 */
        User user = userService.getUser(userId);
        if (user == null) {
            redirectToLogin(response);
            return false;
        }

        /** 授权通过 */
        if (PrivilegeUtils.checkPrivilege(privilege.getId(), user.getPrivilege())) {
            request.setAttribute("user", user);
            return true;
        }

        /** 未验证邮箱 */
        if (user.getPrivilege() == PrivilegeType.EMAIL.getId()) {
            redirectToEmailValidate(response);
            return false;
        }

        redirectToNoAccess(response);
        return false;
    }

    private void redirectToLogin(HttpServletResponse response) throws Exception {
        response.sendRedirect("/login/login");
    }

    private void redirectToEmailValidate(HttpServletResponse response) throws Exception {
        response.sendRedirect("/email/validate");
    }

    private void redirectToNoAccess(HttpServletResponse response) throws Exception {
        response.sendRedirect("/error/noaccess");
    }

}
