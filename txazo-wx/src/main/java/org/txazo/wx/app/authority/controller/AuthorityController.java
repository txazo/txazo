package org.txazo.wx.app.authority.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * AuthorityController
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 30.06.2015
 */
@Controller
@RequestMapping("/authority")
public class AuthorityController {

    @RequestMapping("/error.wx")
    public String error() {
        return "authority/error";
    }

}
