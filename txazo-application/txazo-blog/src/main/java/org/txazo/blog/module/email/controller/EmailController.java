package org.txazo.blog.module.email.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.txazo.blog.common.controller.BaseController;

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

    @RequestMapping("/validate")
    public String validate() {
        return "email/validate";
    }

}
