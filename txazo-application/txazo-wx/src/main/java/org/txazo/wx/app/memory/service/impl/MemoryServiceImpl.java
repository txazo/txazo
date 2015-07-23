package org.txazo.wx.app.memory.service.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.txazo.util.lang.string.CharacterUtils;
import org.txazo.wx.app.memory.bean.Memory;
import org.txazo.wx.app.memory.enums.MemoryType;
import org.txazo.wx.app.memory.mapper.MemoryMapper;
import org.txazo.wx.app.memory.service.MemoryService;

import java.util.*;

/**
 * MemoryServiceImpl
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 27.06.2015
 */
@Service
public class MemoryServiceImpl implements MemoryService {

    @Autowired
    private MemoryMapper memoryMapper;

    @Override
    public boolean addMemory(Memory memory) {
        if (checkMemory(memory)) {
            try {
                memoryMapper.addMemory(memory);
                return memory.getId() > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean checkMemory(Memory memory) {
        return memory != null
                && memory.getParentId() >= 0
                && MemoryType.contains(memory.getType())
                && StringUtils.isNoneBlank(memory.getName());
    }

    @Override
    public boolean deleteMemory(int id) {
        return id > 0 && memoryMapper.deleteMemory(id) > 0;
    }

    @Override
    public boolean updateMemory(Memory memory) {
        return checkMemory(memory) && memoryMapper.updateMemory(memory) > 0;
    }

    @Override
    public boolean updateContentById(int id, String content) {
        if (id <= 0) {
            return false;
        }
        Memory memory = new Memory();
        memory.setId(id);
        memory.setContent(content);
        return memoryMapper.updateContentById(memory) > 0;
    }

    @Override
    public Memory getMemoryById(int id) {
        return id > 0 ? memoryMapper.getMemoryById(id) : null;
    }

    @Override
    public List<Memory> listMemorysByParentId(int parentId) {
        return parentId >= 0 ? memoryMapper.listMemorysByParentId(parentId) : Collections.EMPTY_LIST;
    }

    @Override
    public List<Map<String, Object>> getTrees(int parentId) {
        Map<String, Object> map = null;
        List<Memory> memorys = listMemorysByParentId(parentId);
        List<Map<String, Object>> trees = new ArrayList<Map<String, Object>>();
        if (parentId == 0) {
            addToTrees(0, "根目录", trees);
        }
        if (CollectionUtils.isNotEmpty(memorys)) {
            for (Memory memory : memorys) {
                if (memory.isTree()) {
                    addToTrees(memory.getId(), memory.getName(), trees);
                }
            }
        }
        return trees;
    }

    private void addToTrees(int id, String name, List<Map<String, Object>> trees) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("name", name);
        trees.add(map);
    }

    @Override
    public boolean existsMemory(int parentId, int type, String name) {
        Memory memory = new Memory();
        memory.setParentId(parentId);
        memory.setType(type);
        memory.setName(name);
        return memoryMapper.getMemory(memory) != null;
    }

    @Override
    public List<Map<String, Object>> getParentNames(int id) {
        int maxSize = 3;
        List<Map<String, Object>> names = new ArrayList<Map<String, Object>>();
        addParentNames(StringUtils.EMPTY, id, names);
//        if (names.size() > maxSize) {
//            for (int index = names.size() - 1; index >= maxSize; index--) {
//                names.remove(index);
//            }
//            names.get(maxSize - 1).put("name", "..");
//        }
        addName(0, "Home", names);
        Collections.reverse(names);
        return names;
    }

    private void addParentNames(String merge, int id, List<Map<String, Object>> names) {
        Memory memory = null;
        if (id > 0 && (memory = memoryMapper.getMemoryById(id)) != null) {
            merge += memory.getName();
            if (getLength(merge) > 58) {
                addName(memory.getId(), "src/main", names);
                return;
            }
            addName(memory.getId(), memory.getName(), names);
            addParentNames(merge + " / ", memory.getParentId(), names);
        }
    }

    private void addName(int id, String name, List<Map<String, Object>> names) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        map.put("name", name);
        names.add(map);
    }

    private static int getLength(String str) {
        if (str == null || StringUtils.isBlank(str = str.trim())) {
            return 0;
        }
        int length = 0;
        for (char c : str.toCharArray()) {
            length += CharacterUtils.isChinese(c) ? 3 : 2;
        }
        return length;
    }

}
