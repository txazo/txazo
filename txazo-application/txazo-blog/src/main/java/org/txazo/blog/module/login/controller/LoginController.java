package org.txazo.blog.module.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.txazo.blog.common.controller.BaseController;
import org.txazo.blog.module.login.service.LoginService;

/**
 * LoginController
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.08.2015
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(@RequestParam(value = "userName", required = true) String userName,
                        @RequestParam(value = "passWord", required = true) String passWord,
                        Model model) {
        if (loginService.login(userName, passWord)) {
            return "redirect:/home/index";
        }
        return "login/login";
    }

}
