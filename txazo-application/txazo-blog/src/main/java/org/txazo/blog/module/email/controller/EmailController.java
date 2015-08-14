package org.txazo.blog.module.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.txazo.blog.common.controller.BaseController;
import org.txazo.blog.common.enums.PrivilegeType;
import org.txazo.blog.common.enums.RequestConfig;
import org.txazo.blog.module.code.enums.CodeType;
import org.txazo.blog.module.code.service.CodeService;
import org.txazo.blog.module.email.service.SendEmailService;
import org.txazo.blog.module.user.bean.User;
import org.txazo.blog.module.user.service.UserService;

/**
 * EmailController
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.08.2015
 */
@Controller
@RequestMapping("/email")
public class EmailController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private CodeService authCodeService;

    @Autowired
    private SendEmailService sendEmailService;

    @RequestMapping("/send")
    @RequestConfig(privilege = PrivilegeType.EMAIL)
    public String send() {
        User user = getUser();
        if (user == null) {
            return redirectTo(LOGIN_LOGIN);
        }
        if (user.getPrivilege() == PrivilegeType.EMAIL.getId()) {
            sendEmailService.sendValidateEmail(user.getEmail(), authCodeService.getCode(user.getId(), CodeType.EMAIL_VALIDATE));
        }
        return EMAIL_SEND;
    }

    @RequestMapping("/validate")
    public String validate(@RequestParam(value = "userId", required = true) Integer userId,
                           @RequestParam(value = "code", required = true) String code) {
        if (authCodeService.validateCode(userId, CodeType.EMAIL_VALIDATE, code)) {
            User user = userService.getUser(userId);
            if (user != null && user.getPrivilege() == PrivilegeType.EMAIL.getId()) {
                user.setPrivilege(PrivilegeType.LOGIN.getId());
                if (userService.updateUser(user)) {
                    return "email/succ";
                }
            }
        }
        return "email/fail";
    }

}
