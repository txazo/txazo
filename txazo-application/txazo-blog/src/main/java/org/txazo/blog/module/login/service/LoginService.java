package org.txazo.blog.module.login.service;

import org.txazo.blog.module.user.bean.User;

import javax.servlet.http.HttpServletResponse;

/**
 * LoginService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.08.2015
 */
public interface LoginService {

    public User login(String email, String passWord);

    public void writeLoginCookie(User user, HttpServletResponse response);

}
