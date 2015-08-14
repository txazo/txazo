package org.txazo.blog.module.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.txazo.blog.common.controller.BaseController;
import org.txazo.blog.common.enums.PrivilegeType;
import org.txazo.blog.common.enums.RequestConfig;

/**
 * HomeController
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.08.2015
 */
@Controller
@RequestMapping("/home")
@RequestConfig(privilege = PrivilegeType.LOGIN)
public class HomeController extends BaseController {

    @RequestMapping("/index")
    public String index() {
        return HOME_INDEX;
    }

}
