package org.txazo.wx.quartz.thread;

import org.txazo.wx.app.remind.bean.Remind;
import org.txazo.wx.app.remind.service.RemindService;
import org.txazo.wx.quartz.QuartzScheduler;

import java.util.List;

/**
 * RemindInitThread
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 11.06.2015
 */
public class RemindInitThread implements Runnable {

    private QuartzScheduler quartzScheduler;
    private RemindService remindService;

    @Override
    public void run() {
        System.out.println("----------RemindInitThread run");
        List<Remind> reminds = remindService.getAllValidReminds("txazo1218");
        for (Remind remind : reminds) {
            quartzScheduler.scheduleRemindJob(remind);
        }
    }

    public RemindService getRemindService() {
        return remindService;
    }

    public void setRemindService(RemindService remindService) {
        this.remindService = remindService;
    }

    public QuartzScheduler getQuartzScheduler() {
        return quartzScheduler;
    }

    public void setQuartzScheduler(QuartzScheduler quartzScheduler) {
        this.quartzScheduler = quartzScheduler;
    }

}
