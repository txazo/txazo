package org.txazo.wx.app.remind.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.txazo.wx.SpringAbstractTest;
import org.txazo.wx.app.remind.bean.Remind;
import org.txazo.wx.app.remind.service.RemindService;

import java.util.List;

/**
 * RemindServiceTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 04.06.2015
 */
public class RemindServiceTest extends SpringAbstractTest {

    @Autowired
    private RemindService remindService;

    @Test
    public void testAddRemind() {
        Remind remind = new Remind("txazo1218", "健康提醒", "喝水啦～～做做运动啦！！！", "*/20 * * * * ?");
        Assert.assertTrue(remindService.addRemind(remind));
    }

    @Test
    public void testUpdateRemind() {
        Remind remind = new Remind();
        remind.setId(1);
        remind.setAccount("txazo");
        remind.setTitle("标题");
        remind.setDescription("描述");
        remind.setCronExpression("*/5 * * * * ?");
        remind.setTotalTimes(100);
        Assert.assertTrue(remindService.updateRemind(remind));
    }

    @Test
    public void testDeleteRemind() {
        Assert.assertTrue(remindService.deleteRemind(1));
    }

    @Test
    public void testGetRemind() {
        Remind remind = remindService.getRemind(1);
        Assert.assertNotNull(remind);
    }

    @Test
    public void testGetAllReminds() {
        List<Remind> reminds = remindService.getAllReminds("txazo");
        Assert.assertTrue(reminds.size() > 0);
    }

}
