package org.txazo.wx.app.memory.service.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return memoryMapper.existsMemory(parentId, type, name) > 0;
    }

}
