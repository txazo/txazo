package org.txazo.wx.app.remind.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.txazo.util.schedule.quartz.QuartzScheduler;
import org.txazo.util.schedule.quartz.build.JobBuilder;
import org.txazo.util.schedule.quartz.build.KeyBuilder;
import org.txazo.util.schedule.quartz.build.TriggerBuilder;
import org.txazo.util.schedule.quartz.job.JobData;
import org.txazo.wx.app.remind.bean.Remind;
import org.txazo.wx.app.remind.job.RemindJob;
import org.txazo.wx.app.remind.job.RemindJobCallback;

import javax.annotation.Resource;

/**
 * RemindSchedule
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 17.07.2015
 */
@Component
public class RemindSchedule {

    @Autowired
    private RemindService remindService;

    @Resource
    private QuartzScheduler quartzScheduler;

    public void addRemindSchedule(Remind remind) {
        quartzScheduler.addSchedule(JobBuilder.newJobDetail(String.valueOf(remind.getId()), RemindJob.class,
                        new JobData<Remind>(remind), new RemindJobCallback(remindService)),
                TriggerBuilder.newCronTrigger(remind.getExt().getCronExpression(),
                        KeyBuilder.newTriggerKey(String.valueOf(remind.getId()), RemindJob.class)));
    }

}
