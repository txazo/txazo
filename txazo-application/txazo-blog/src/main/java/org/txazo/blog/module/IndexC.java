package org.txazo.blog.module;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexC {

    @RequestMapping("/show")
    public String index(Model model) {
        model.addAttribute("name", "sasas");
        return "hello";
    }

}
