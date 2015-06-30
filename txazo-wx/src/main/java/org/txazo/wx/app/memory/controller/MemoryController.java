package org.txazo.wx.app.memory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.txazo.wx.app.authority.AuthorityType;
import org.txazo.wx.app.authority.annotation.AuthorityControl;
import org.txazo.wx.app.common.util.ResponseUtils;
import org.txazo.wx.app.memory.bean.Memory;
import org.txazo.wx.app.memory.service.MemoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * MemoryController
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 27.06.2015
 */
@RequestMapping("/memory")
@Controller
public class MemoryController {

    @Autowired
    private MemoryService memoryService;

    @RequestMapping("home.wx")
    @AuthorityControl(type = AuthorityType.READ)
    public String home(HttpServletRequest request) {
        request.setAttribute("type", 1);
        request.setAttribute("parentId", 0);
        request.setAttribute("title", "Home");
        request.setAttribute("titles", memoryService.getParentNames(0));
        request.setAttribute("memorys", memoryService.listMemorysByParentId(0));
        return "/memory/tree";
    }

    @RequestMapping("show.wx")
    public String show(@RequestParam(value = "id", required = true) Integer id,
                       HttpServletRequest request) {
        Memory memory = memoryService.getMemoryById(id);
        if (memory == null) {
            return "redirect:/memory/home.wx";
        }
        if (memory.isTree()) {
            return "redirect:/memory/showTree.wx?parentId=" + id;
        }
        return "redirect:/memory/showNode.wx?id=" + id;
    }

    @RequestMapping("showTree.wx")
    public String showTree(@RequestParam(value = "parentId", required = true) Integer parentId,
                           HttpServletRequest request) {
        Memory memory = null;
        if (parentId <= 0 || (memory = memoryService.getMemoryById(parentId)) == null) {
            return "redirect:/memory/home.wx";
        }
        request.setAttribute("type", 0);
        request.setAttribute("parentId", parentId);
        request.setAttribute("title", memory.getName());
        request.setAttribute("titles", memoryService.getParentNames(parentId));
        request.setAttribute("memorys", memoryService.listMemorysByParentId(parentId));
        return "memory/tree";
    }

    @RequestMapping("showNode.wx")
    public String showNode(@RequestParam(value = "id", required = true) Integer id,
                           HttpServletRequest request) {
        Memory memory = memoryService.getMemoryById(id);
        request.setAttribute("memory", memory);
        return "memory/node";
    }

    @RequestMapping("add.wx")
    @AuthorityControl(type = AuthorityType.WRITE)
    public String add(@RequestParam(value = "type", defaultValue = "0", required = false) Integer type,
                      @RequestParam(value = "parentId", defaultValue = "0", required = false) Integer parentId,
                      HttpServletRequest request) {
        request.setAttribute("type", type);
        request.setAttribute("parentId", parentId);
        request.setAttribute("titles", memoryService.getParentNames(parentId));
        return "memory/add";
    }

    @RequestMapping("addMemory.wx")
    public String addMemory(Memory memory) {
        if (memoryService.addMemory(memory)) {
            return "redirect:/memory/showTree.wx?parentId=" + memory.getParentId();
        }
        return "memory/add";
    }

    @RequestMapping("checkMemory.wx")
    public void checkMemory(@RequestParam(value = "parentId", required = true) Integer parentId,
                            @RequestParam(value = "type", required = true) Integer type,
                            @RequestParam(value = "name", required = true) String name,
                            HttpServletResponse response) {
        boolean exists = memoryService.existsMemory(parentId, type, name);
        ResponseUtils.renderJson(response, "{\"exists\" : \"" + exists + "\"}");
    }

}
