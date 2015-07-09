package org.txazo.wx.app.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.txazo.wx.app.common.enums.RequestConfig;
import org.txazo.wx.app.common.enums.PrivilegeType;
import org.txazo.wx.app.email.bean.Email;
import org.txazo.wx.app.email.service.EmailService;

import javax.servlet.http.HttpServletRequest;

/**
 * EmailController
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 19.06.2015
 */
@Controller
@RequestMapping("/email")
@RequestConfig(privilege = PrivilegeType.EMAIL)
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("/read/{id}.wx")
    public String read(@PathVariable Integer id, HttpServletRequest request) {
        if (id == null) {
            return null;
        }
        Email email = emailService.getEmail(id);
        if (email == null) {
            return null;
        }
        request.setAttribute("content", email.getContent());
        return "email/read";
    }

}
