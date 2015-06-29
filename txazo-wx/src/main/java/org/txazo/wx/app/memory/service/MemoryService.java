package org.txazo.wx.app.memory.service;

import org.txazo.wx.app.memory.bean.Memory;

import java.util.List;
import java.util.Map;

/**
 * MemoryService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 27.06.2015
 */
public interface MemoryService {

    public boolean addMemory(Memory memory);

    public boolean deleteMemory(int id);

    public boolean updateMemory(Memory memory);

    public Memory getMemoryById(int id);

    public List<Memory> listMemorysByParentId(int parentId);

    List<Map<String, Object>> getTrees(int parentId);

    public boolean existsMemory(int parentId, int type, String name);

    public List<Map<String, Object>> getParentNames(int id);

}
