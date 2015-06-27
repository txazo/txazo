package org.txazo.wx.app.memory;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.txazo.wx.SpringAbstractTest;
import org.txazo.wx.app.memory.bean.Memory;
import org.txazo.wx.app.memory.enums.MemoryType;
import org.txazo.wx.app.memory.service.MemoryService;

/**
 * MemoryServiceTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 27.06.2015
 */
public class MemoryServiceTest extends SpringAbstractTest {

    @Autowired
    private MemoryService memoryService;

    @Test
    public void testAddMemory() {
        Memory memory = new Memory();
        memory.setParentId(0);
        memory.setType(MemoryType.TREE);
        memory.setName("缓存");
        Assert.assertTrue(memoryService.addMemory(memory));
    }

    @Test
    public void testDeleteMemory() {
        Assert.assertTrue(memoryService.deleteMemory(1));
    }

    @Test
    public void testUpdateMemory() {
        Memory memory = new Memory();
        memory.setId(1);
        memory.setName("Cache");
        Assert.assertTrue(memoryService.updateMemory(memory));
    }

}
