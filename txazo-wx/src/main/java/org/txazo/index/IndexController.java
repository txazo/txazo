package org.txazo.index;

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
//@RequestMapping("/")
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}
