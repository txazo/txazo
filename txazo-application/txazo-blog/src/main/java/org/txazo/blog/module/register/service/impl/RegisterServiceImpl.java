package org.txazo.blog.module.register.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.txazo.blog.common.util.CodeUtils;
import org.txazo.blog.common.util.LoginUtils;
import org.txazo.blog.common.util.PrivilegeUtils;
import org.txazo.blog.module.register.service.RegisterService;
import org.txazo.blog.module.register.bean.RegisterResult;
import org.txazo.blog.module.register.util.RegisterUtils;
import org.txazo.blog.module.user.bean.User;
import org.txazo.blog.module.user.service.UserService;

/**
 * RegisterServiceImpl
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.08.2015
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    private static final String DEFAULT_AVATAR = "default.jpg";

    @Autowired
    private UserService userService;

    @Override
    public RegisterResult register(String email, String passWord, String userName) {
        if (!RegisterUtils.isValidEmail(email)) {
            return RegisterResult.fail("邮箱格式有误");
        }

        if (!RegisterUtils.isValidPassWord(passWord)) {
            return RegisterResult.fail("密码格式有误");
        }

        if (!RegisterUtils.isValidUserName(userName)) {
            return RegisterResult.fail("昵称格式有误");
        }

        if (userService.getUserByEmail(email) != null) {
            return RegisterResult.fail("邮箱已被注册");
        }

        if (userService.getUserByUserName(userName) != null) {
            return RegisterResult.fail("昵称已被注册");
        }

        User user = new User();
        user.setEmail(email);
        user.setEncryptKey(CodeUtils.generateCode(8));
        user.setPassWord(LoginUtils.generatePassWord(passWord, user.getEncryptKey()));
        user.setUserName(userName);
        user.setAvatar(DEFAULT_AVATAR);
        user.setPrivilege(PrivilegeUtils.generatePrivilege(email).getId());

        if (!userService.addUser(user)) {
            return RegisterResult.fail("注册失败");
        }

        return RegisterResult.RESULT_SUCC;
    }

}
