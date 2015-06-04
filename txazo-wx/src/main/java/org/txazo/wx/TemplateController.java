package org.txazo.wx;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * IndexController
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.06.2015
 */
@Controller
@RequestMapping("/template")
public class TemplateController {

    @RequestMapping("/t_1.wx")
    public String t_01() {
        return "template/t_1";
    }

    @RequestMapping("/t_2.wx")
    public String t_02() {
        return "template/t_2";
    }

    @RequestMapping("/t_3.wx")
    public String t_03() {
        return "template/t_3";
    }

    @RequestMapping("/t_4.wx")
    public String t_04() {
        return "template/t_4";
    }

    @RequestMapping("/t_5.wx")
    public String t_05() {
        return "template/t_5";
    }

    @RequestMapping("/t_12.wx")
    public String t_12() {
        return "template/t_12";
    }

}
