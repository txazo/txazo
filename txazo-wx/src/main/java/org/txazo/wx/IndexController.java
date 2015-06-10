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
public class IndexController {

    @RequestMapping("/index.wx")
    public String index() {
        return "index";
    }

    @RequestMapping("/html5.wx")
    public String html5() {
        return "html5";
    }

    @RequestMapping("/html5_1.wx")
    public String html5_1() {
        return "html5_1";
    }

    @RequestMapping("/html5_2.wx")
    public String html5_2() {
        return "html5_2";
    }

}
