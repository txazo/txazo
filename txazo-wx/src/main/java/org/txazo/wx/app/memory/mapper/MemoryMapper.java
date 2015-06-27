package org.txazo.wx.app.memory.mapper;

import org.txazo.wx.app.memory.bean.Memory;

import java.util.List;

/**
 * MemoryMapper
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 27.06.2015
 */
public interface MemoryMapper {

    public int addMemory(Memory memory);

    public int deleteMemory(int id);

    public int updateMemory(Memory memory);

    public Memory getMemoryById(int id);

    public List<Memory> listMemorysByParentId(int parentId);

    public Memory getMemory(Memory memory);

}
