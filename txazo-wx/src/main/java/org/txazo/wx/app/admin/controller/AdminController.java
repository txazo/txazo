package org.txazo.wx.app.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.txazo.wx.app.common.enums.RequestConfig;
import org.txazo.wx.app.common.enums.PrivilegeType;

/**
 * AdminController
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.07.2015
 */
@Controller
@RequestMapping("/admin")
@RequestConfig(authority = PrivilegeType.ADMIN)
public class AdminController {

}
