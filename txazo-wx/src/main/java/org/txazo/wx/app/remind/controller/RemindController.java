package org.txazo.wx.app.remind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.txazo.wx.app.common.enums.RequestConfig;
import org.txazo.wx.app.common.enums.PrivilegeType;

/**
 * IndexController
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 04.06.2015
 */
@Controller
@RequestMapping("/remind")
@RequestConfig(privilege = PrivilegeType.REMIND)
public class RemindController {

}
