package org.txazo.wx.app.remind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.txazo.wx.app.authority.annotation.RequestConfig;
import org.txazo.wx.app.authority.enums.AuthorityType;

/**
 * IndexController
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 04.06.2015
 */
@Controller
@RequestMapping("/remind")
@RequestConfig(authority = AuthorityType.REMIND)
public class RemindController {

}
