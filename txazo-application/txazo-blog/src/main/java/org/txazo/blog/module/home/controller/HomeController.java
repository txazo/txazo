package org.txazo.blog.module.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.txazo.blog.common.controller.BaseController;

/**
 * HomeController
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.08.2015
 */
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController {

    @RequestMapping("/index")
    public String index() {
        return "home/index";
    }

}
