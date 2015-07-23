package org.txazo.wx.app.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.txazo.util.web.cookie.CookieUtils;
import org.txazo.util.web.servlet.ResponseUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CommonController
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 30.06.2015
 */
@Controller
@RequestMapping("/common")
public class CommonController {

    @RequestMapping("/noaccess")
    public String noaccess() {
        return "common/noaccess";
    }

    @RequestMapping("/clearCookie")
    public void clearCookie(HttpServletRequest request, HttpServletResponse response) {
        CookieUtils.removeCookie(request, response, "user_id");
        CookieUtils.removeCookie(request, response, "login_key");
        CookieUtils.removeCookie(request, response, "auth_count");
        ResponseUtils.renderText(response, "success");
    }

}
