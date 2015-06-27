package org.txazo.wx.app.memory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.txazo.wx.app.common.util.ResponseUtils;
import org.txazo.wx.app.memory.bean.Memory;
import org.txazo.wx.app.memory.enums.MemoryType;
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

    @RequestMapping("addRoot.wx")
    public String addRoot(HttpServletRequest request) {
        request.setAttribute("parentId", 0);
        request.setAttribute("type", MemoryType.ROOT.getId());
        return "memory/add-root";
    }

    @RequestMapping("addNode.wx")
    public String addNode(Memory memory) {
        if (memoryService.addMemory(memory)) {
            return "redirect:/memory/toMemory.wx?id=" + memory.getId();
        }
        return "memory/add-node";
    }

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("index.wx")
    public String index() {
        return "memory/index";
    }

    /**
     * 目录
     *
     * @return
     */
    @RequestMapping("tree.wx")
    public String tree() {
        return "memory/tree";
    }

    @RequestMapping("toMemory.wx")
    public String toMemory(@RequestParam(value = "id", required = true) Integer id,
                           HttpServletRequest request) {
        Memory memory = memoryService.getMemoryById(id);
        if (memory == null) {
            return "redirect:/memory/index.wx";
        }
        if (memory.isTree()) {
            return "redirect:/memory/tree.wx";
        }
        request.setAttribute("memory", memory);
        return "memory/node";
    }

    public void getTrees(@RequestParam(value = "parentId", required = true) Integer parentId,
                         HttpServletResponse response) {

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
