package org.txazo.wx.app.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.txazo.util.web.servlet.ResponseUtils;
import org.txazo.wx.app.common.enums.RequestConfig;
import org.txazo.wx.app.common.enums.PrivilegeType;

import javax.servlet.http.HttpServletResponse;

/**
 * UserController
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.07.2015
 */
@Controller
@RequestMapping("/user")
@RequestConfig(privilege = PrivilegeType.USER)
public class UserController {

    @RequestMapping("list.wx")
    public void list(HttpServletResponse response) {
        ResponseUtils.renderJson(response, "{\"Code\" : 1}");
    }

}
