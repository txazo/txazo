package org.txazo.wx.quartz;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.txazo.wx.SpringAbstractTest;
import org.txazo.wx.app.remind.bean.Remind;
import org.txazo.wx.app.remind.service.RemindService;

public class QuartzSchedulerTest extends SpringAbstractTest {

    @Autowired
    private QuartzScheduler quartzScheduler;

    @Autowired
    private RemindService remindService;

    @Test
    public void testSendRemind() throws Exception {
        Remind remind = remindService.getRemind(1);
        quartzScheduler.scheduleRemindJob(remind);

        Thread.sleep(100000);
    }

}
