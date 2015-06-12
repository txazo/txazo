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
        remindService.addRemind(new Remind("txazo1218", "健康提醒", "喝水啦，休息一下吧/::P/::P/::P", "0 0 11,13,14,15,16,17,18,22,23 * * ?"));
        remindService.addRemind(new Remind("txazo1218", "睡眠提醒", "睡前吃个水果吧/::g/::g/::g", "0 0 21 * * ?"));
        remindService.addRemind(new Remind("txazo1218", "运动提醒", "睡觉前，运动一下吧/:jump/:jump/:jump", "0 30 22 * * ?"));
        remindService.addRemind(new Remind("txazo1218", "睡眠提醒", "关电脑，睡觉啦/::Z/::Z/::Z", "0 30 23 * * ?"));

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
