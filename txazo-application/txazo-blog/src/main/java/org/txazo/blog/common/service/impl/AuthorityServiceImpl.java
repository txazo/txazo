package org.txazo.blog.common.service.impl;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.txazo.blog.common.cache.CacheService;
import org.txazo.blog.common.enums.PrivilegeType;
import org.txazo.blog.common.service.AuthorityService;
import org.txazo.blog.common.util.PrivilegeUtils;
import org.txazo.blog.module.user.bean.User;
import org.txazo.blog.module.user.service.UserService;
import org.txazo.util.web.cookie.CookieUtils;

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

    private static final String ADMIN_USER_NAME = "txazo1218";

    @Autowired
    private UserService userService;

    @Resource
    private CacheService cacheService;

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

        /** 缓存是否失效 */
        boolean cacheMissed = false;
        /** sessionId */
        String sessionId = request.getSession().getId();
        /** userId */
        int userId = NumberUtils.toInt(CookieUtils.getCookieValue(COOKIE_USER_ID, request), 0);
        /** 登录验证key */
        String loginKey = CookieUtils.getCookieValue(COOKIE_LOGIN_KEY, request);
        /** 未通过验证或缓存失效 */
        if (userId == 0 || (cacheMissed = cacheService.get(sessionId) == null)) {
            User user = null;
            /** 用户权限验证 */
            if ((user != null && PrivilegeUtils.checkPrivilege(privilege.getId(), user.getPrivilege()))) {
                /** 通过权限验证 */
                request.setAttribute("user", user);
                cacheService.set(sessionId, "1");
                CookieUtils.removeCookie(request, response, COOKIE_AUTH_COUNT);
                CookieUtils.setCookie(response, COOKIE_USER_ID, String.valueOf(user.getId()), COOKIE_MAX_AGE);
                CookieUtils.setCookie(response, COOKIE_LOGIN_KEY, PrivilegeUtils.generateLoginKey(user.getId(), "1"), COOKIE_MAX_AGE);
                return true;
            }

            return false;
        }

        /** Cookie验证 */
        boolean passedAuthority = PrivilegeUtils.generateLoginKey(userId, cacheService.get(sessionId, String.class)).equals(loginKey);
        if (passedAuthority) {
            request.setAttribute("user", userService.getUser(userId));
        } else {
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
