package org.txazo.blog.module.register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.txazo.blog.common.controller.BaseController;
import org.txazo.blog.module.register.bean.RegisterResult;
import org.txazo.blog.module.register.service.RegisterService;

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
    private RegisterService registerService;

    @RequestMapping("/register")
    public String login(@RequestParam(value = "email", required = true) String email,
                        @RequestParam(value = "passWord", required = true) String passWord,
                        @RequestParam(value = "userName", required = true) String userName,
                        Model model) {
        RegisterResult result = registerService.register(email, passWord, userName);
        if (result.succ()) {
            return "redirect:/email/validate";
        }
        model.addAttribute("result", result);
        return "register/register";
    }

}
