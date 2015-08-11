package org.txazo.blog.module.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.txazo.blog.common.enums.PrivilegeType;
import org.txazo.blog.common.enums.RequestConfig;
import org.txazo.blog.module.blog.service.BlogCatalogService;

@Controller
@RequestMapping("/blog/catalog")
@RequestConfig(privilege = PrivilegeType.ADMIN)
public class BlogCatalogController {

    @Autowired
    private BlogCatalogService blogCatalogService;

    @RequestMapping("/list")
    public String list(@RequestParam(value = "", defaultValue = "0", required = false) Integer parentId,
                       Model model) {
        model.addAttribute("catalogs", blogCatalogService.listCatalogs(parentId));
        return "blog/catalog/list";
    }

}
