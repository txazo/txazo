package org.txazo.blog.module.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.txazo.blog.common.cache.CacheService;
import org.txazo.blog.common.util.LoginUtils;
import org.txazo.blog.module.login.service.LoginService;
import org.txazo.blog.module.user.bean.User;
import org.txazo.blog.module.user.service.UserService;
import org.txazo.util.web.cookie.CookieUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * LoginServiceImpl
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.08.2015
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static final String LOGIN_CODE_KEY = "Login_Code_";

    @Autowired
    private UserService userService;

    @Resource
    private CacheService cacheService;

    @Override
    public User login(String email, String passWord) {
        User user = userService.getUserByEmail(email);
        if (user != null) {
            if (LoginUtils.login(user, passWord)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void writeLoginCookie(User user, HttpServletResponse response) {
        if (user == null || response == null) {
            return;
        }
        String code = LoginUtils.generateEncryptKey();
        cacheService.set(getLoginCodeKey(user.getId()), code, 1800);
        CookieUtils.setCookie(response, LoginUtils.COOKIE_USER_ID, String.valueOf(user.getId()), 1800);
        CookieUtils.setCookie(response, LoginUtils.COOKIE_LOGIN_KEY, LoginUtils.generateLoginKey(user.getId(), code), 1800);
    }

    private String getLoginCodeKey(int userId) {
        return LOGIN_CODE_KEY + userId;
    }

    @Override
    public String getLoginCode(int userId) {
        return cacheService.get(getLoginCodeKey(userId), String.class);
    }

}
