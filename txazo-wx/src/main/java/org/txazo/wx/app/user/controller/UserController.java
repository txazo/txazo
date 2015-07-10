package org.txazo.wx.app.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.txazo.util.lang.JSONUtils;
import org.txazo.util.web.servlet.ResponseUtils;
import org.txazo.wx.app.common.controller.base.BaseController;
import org.txazo.wx.app.common.enums.RequestConfig;
import org.txazo.wx.app.common.enums.PrivilegeType;
import org.txazo.wx.app.user.bean.User;
import org.txazo.wx.app.user.service.UserService;

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
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("add")
    public String add(User user) {
        if (userService.addUser(user)) {
            return "redirect:/user/list";
        }
        return "user/add";
    }

    @RequestMapping("list")
    public void list(HttpServletResponse response) {
        System.out.println("user: " + getUserName());
        ResponseUtils.renderJson(response, "{\"Code\" : 1}");
    }

    @RequestMapping("checkUserExists")
    public void checkUserExists(@RequestParam(value = "userName", required = true) String userName,
                                HttpServletResponse response) {
        ResponseUtils.renderJson(response, JSONUtils.buildJSONString("exists", userService.existsUser(userName)));
    }

}
