package org.txazo.wx.app.memory.controller;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.txazo.util.web.servlet.ResponseUtils;
import org.txazo.wx.app.memory.bean.Memory;
import org.txazo.wx.app.memory.service.MemoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MemoryController
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 27.06.2015
 */
@Controller
@RequestMapping("/memory")
public class MemoryController {

    @Autowired
    private MemoryService memoryService;

    @RequestMapping("home.wx")
    public String home(HttpServletRequest request) {
        return "forward:/memory/showTree.wx?type=1&parentId=0";
    }

    @RequestMapping("show.wx")
    public String show(@RequestParam(value = "id", required = true) Integer id,
                       HttpServletRequest request) {
        Memory memory = memoryService.getMemoryById(id);
        if (memory == null) {
            return "redirect:/memory/home.wx";
        }
        if (memory.isTree()) {
            return "forward:/memory/showTree.wx?parentId=" + id;
        }
        return "forward:/memory/showNode.wx?id=" + id;
    }

    @RequestMapping("showTree.wx")
    public String showTree(@RequestParam(value = "type", required = false, defaultValue = "0") Integer type,
                           @RequestParam(value = "parentId", required = true) Integer parentId,
                           HttpServletRequest request) {
        Memory memory = null;
        if (parentId < 0 || (parentId > 0 && (memory = memoryService.getMemoryById(parentId)) == null)) {
            return "redirect:/memory/home.wx";
        }
        request.setAttribute("type", type);
        request.setAttribute("parentId", parentId);
        request.setAttribute("title", parentId == 0 ? "Home" : memory.getName());
        request.setAttribute("titles", memoryService.getParentNames(parentId));
        request.setAttribute("memorys", memoryService.listMemorysByParentId(parentId));
        return "memory/tree";
    }

    @RequestMapping("showNode.wx")
    public String showNode(@RequestParam(value = "id", required = true) Integer id,
                           HttpServletRequest request) {
        Memory memory = memoryService.getMemoryById(id);
        if (memory == null) {
            return "redirect:/memory/home.wx";
        }
        request.setAttribute("memory", memory);
        request.setAttribute("title", memory.getName());
        request.setAttribute("titles", memoryService.getParentNames(id));
        return "memory/node";
    }

    @RequestMapping("add.wx")
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
            return "redirect:/memory/show.wx?id=" + memory.getParentId();
        }
        return "memory/add";
    }

    @RequestMapping("editNode.wx")
    public String editNode(@RequestParam(value = "id", required = true) Integer id,
                           HttpServletRequest request) {
        Memory memory = memoryService.getMemoryById(id);
        if (memory == null) {
            return "redirect:/memory/home.wx";
        }
        request.setAttribute("memory", memory);
        request.setAttribute("title", memory.getName());
        request.setAttribute("titles", memoryService.getParentNames(id));
        return "memory/node-edit";
    }

    @RequestMapping("updateNode.wx")
    public String updateNode(@RequestParam(value = "id", required = true) Integer id,
                             @RequestParam(value = "point", required = true) String[] point,
                             HttpServletRequest request) {
        Memory memory = memoryService.getMemoryById(id);
        if (memory == null) {
            return "redirect:/memory/home.wx";
        }
        memoryService.updateContentById(id, createJson("point", point));
        return "redirect:/memory/show.wx?id=" + id;
    }

    @RequestMapping("checkMemory.wx")
    public void checkMemory(@RequestParam(value = "parentId", required = true) Integer parentId,
                            @RequestParam(value = "type", required = true) Integer type,
                            @RequestParam(value = "name", required = true) String name,
                            HttpServletResponse response) {
        boolean exists = memoryService.existsMemory(parentId, type, name);
        ResponseUtils.renderJson(response, "{\"exists\" : \"" + exists + "\"}");
    }

    private String createJson(String key, String[] values) {
        if (StringUtils.isBlank(key) || ArrayUtils.isEmpty(values)) {
            return null;
        }
        List<String> valueList = new ArrayList<String>();
        for (String value : values) {
            if (StringUtils.isNotBlank(value)) {
                valueList.add(value);
            }
        }
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        jsonMap.put(key, valueList);
        return JSONArray.toJSONString(jsonMap);
    }

}
