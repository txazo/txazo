package org.txazo.wx.application.remind.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.txazo.wx.SpringAbstractTest;
import org.txazo.wx.application.remind.bean.Remind;

/**
 * RemindMapperTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 04.06.2015
 */
public class RemindMapperTest extends SpringAbstractTest {

    @Autowired
    private RemindMapper remindMapper;

    @Test
    public void testAddRemind() {
        Remind remind = new Remind();
        remind.setTitle("txazo");
        remindMapper.addRemind(remind);
    }

}
