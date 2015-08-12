package org.txazo.blog.module.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.txazo.blog.common.util.LoginUtils;
import org.txazo.blog.module.login.service.LoginService;
import org.txazo.blog.module.user.bean.User;
import org.txazo.blog.module.user.service.UserService;

/**
 * LoginServiceImpl
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.08.2015
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserService userService;

    @Override
    public boolean login(String userName, String passWord) {
        User user = userService.getUserByUserName(userName);
        if (user == null) {
            return false;
        }

        return LoginUtils.generatePassWord(passWord, user.getEncryptKey()).
                equals(user.getPassWord());
    }

}
