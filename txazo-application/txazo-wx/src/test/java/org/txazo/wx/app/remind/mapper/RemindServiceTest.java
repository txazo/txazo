package org.txazo.wx.app.remind.mapper;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.txazo.wx.SpringAbstractTest;
import org.txazo.wx.app.remind.bean.Remind;
import org.txazo.wx.app.remind.bean.RemindExt;
import org.txazo.wx.app.remind.enums.RemindShowType;
import org.txazo.wx.app.remind.enums.RemindType;
import org.txazo.wx.app.remind.service.RemindService;

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
        Remind remind = new Remind();
        remind.setUserName("txazo1218");
        remind.setType(RemindType.DIET.getId());

        RemindExt ext = new RemindExt();
        ext.setCronExpression("* */10 * * * ?");
        ext.setShowType(RemindShowType.RANDOM.getId());
        ext.setContent(new String[]{"Content A", "Content B"});

        remind.setExt(ext);

        Assert.assertTrue(remindService.addRemind(remind));
    }

    @Test
    public void testDeleteRemind() {
        remindService.deleteRemind(1);
    }

    @Test
    public void testUpdateRemind() {
        Remind remind = remindService.getRemind(1);
        remind.setType(RemindType.SLEEP.getId());
        Assert.assertTrue(remindService.updateRemind(remind));
    }

    @Test
    public void testUpdateRemindStatus() {
        Remind remind = new Remind();
        remind.setId(1);
        remind.setStatus(1);
        remindService.updateRemindStatus(remind);
    }

    @Test
    public void testGetRemind() {
        Remind remind = remindService.getRemind(1);
        Assert.assertNotNull(remind);
    }

    @Test
    public void testGetRemindsByUserName() {
        List<Remind> reminds = remindService.getRemindsByUserName("txazo1218");
        Assert.assertTrue(CollectionUtils.isNotEmpty(reminds));
    }

    @Test
    public void testGetAllValidReminds() {
        List<Remind> reminds = remindService.getAllValidReminds();
        Assert.assertTrue(CollectionUtils.isNotEmpty(reminds));
    }

}
