package org.txazo.blog.module.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.txazo.blog.common.controller.BaseController;
import org.txazo.blog.module.login.service.LoginService;
import org.txazo.blog.module.register.bean.RegisterResult;
import org.txazo.blog.module.register.service.RegisterService;
import org.txazo.blog.module.user.bean.User;
import org.txazo.blog.module.user.service.UserService;

/**
 * RegisterController
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.08.2015
 */
@Controller
@RequestMapping("/register")
public class RegisterController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private RegisterService registerService;

    @RequestMapping("/register")
    public String register(@RequestParam(value = "email", required = true) String email,
                           @RequestParam(value = "passWord", required = true) String passWord,
                           @RequestParam(value = "userName", required = true) String userName,
                           Model model) {
        RegisterResult result = registerService.register(email, passWord, userName);
        if (result.succ()) {
            User user = userService.getUserByEmail(email);
            if (user != null) {
                loginService.writeLoginCookie(user, getResponse());
                return redirectTo(HOME_INDEX);
            }
        }
        model.addAttribute("result", result);
        return REGISTER_REGISTER;
    }

}
