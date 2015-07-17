package org.txazo.wx.app.remind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.txazo.wx.app.common.controller.base.BaseController;
import org.txazo.wx.app.common.enums.RequestConfig;
import org.txazo.wx.app.common.enums.PrivilegeType;
import org.txazo.wx.app.remind.bean.Remind;
import org.txazo.wx.app.remind.bean.RemindExt;
import org.txazo.wx.app.remind.enums.RemindShowType;
import org.txazo.wx.app.remind.enums.RemindType;
import org.txazo.wx.app.remind.service.RemindSchedule;
import org.txazo.wx.app.remind.service.RemindService;

import javax.servlet.http.HttpServletRequest;

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
public class RemindController extends BaseController {

    @Autowired
    private RemindService remindService;

    @Autowired
    private RemindSchedule remindSchedule;

    @RequestMapping("/list")
    public String list() {
        return "remind/list";
    }

    @RequestMapping("/add")
    public String add(Remind remind, RemindExt ext, HttpServletRequest request) {
        if (remind != null) {
            remind.setUserName("txazo1218");
            remind.setExt(ext);
            if (remindService.addRemind(remind)) {
                remindSchedule.addRemindSchedule(remind);
                return "redirect:/user/list";
            }
        }

        request.setAttribute("remindTypes", RemindType.values());
        request.setAttribute("remindShowTypes", RemindShowType.values());
        return "remind/add";
    }

}
