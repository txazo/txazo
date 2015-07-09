package org.txazo.wx.app.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/noaccess.wx")
    public String noaccess() {
        return "common/noaccess";
    }

}
