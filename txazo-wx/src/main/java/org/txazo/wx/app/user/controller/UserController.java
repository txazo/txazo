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
import org.txazo.wx.app.common.util.PrivilegeUtils;
import org.txazo.wx.app.user.bean.User;
import org.txazo.wx.app.user.service.UserService;

import javax.servlet.http.HttpServletRequest;
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

    @RequestMapping("/add")
    public String add(User user) {
        if (userService.addUser(user)) {
            return "redirect:/user/list";
        }
        return "user/add";
    }

    @RequestMapping("/list")
    public String list(HttpServletRequest request) {
        request.setAttribute("users", userService.getAllUsers());
        return "user/list";
    }

    @RequestMapping("/privilege/show")
    public String showPrivilege(@RequestParam(value = "userId", required = true) Integer userId,
                                HttpServletRequest request) {
        User user = userService.getUser(userId);
        if (user == null) {
            return "redirect:/user/list";
        }
        request.setAttribute("userId", user.getId());
        request.setAttribute("privileges", PrivilegeUtils.getPrivilegeDisplays(user.getPrivilege()));
        return "user/privilege-show";
    }

    @RequestMapping("/privilege/update")
    public String updatePrivilege(@RequestParam(value = "userId", required = true) Integer userId,
                                  @RequestParam(value = "privilege", required = false) Integer[] privilege,
                                  HttpServletRequest request) {
        User user = userService.getUser(userId);
        if (user == null) {
            return "redirect:/user/list";
        }
        user.setPrivilege(PrivilegeUtils.getPrivilege(privilege));
        userService.updateUser(user);
        return "redirect:/user/privilege/show?userId=" + userId;
    }

    @RequestMapping("checkUserExists")
    public void checkUserExists(@RequestParam(value = "userName", required = true) String userName,
                                HttpServletResponse response) {
        ResponseUtils.renderJson(response, JSONUtils.buildJSONString("exists", userService.existsUser(userName)));
    }

}
