package org.txazo.wx.quartz;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.txazo.wx.app.remind.bean.Remind;
import org.txazo.wx.app.remind.service.RemindService;
import org.txazo.wx.quartz.bean.JobLimit;
import org.txazo.wx.quartz.job.RemindJob;
import org.txazo.wx.quartz.job.RemindJobDetail;

import javax.annotation.Resource;

import java.util.TimeZone;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * QuartzScheduler
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 11.06.2015
 */
@Component
public class QuartzScheduler {

    @Resource
    private Scheduler scheduler;

    @Autowired
    private RemindService remindService;

    private JobDetail buildJobDetail(Class<? extends Job> jobClass, Remind remind) {
        RemindJobDetail job = new RemindJobDetail();
        job.setJobClass(jobClass);
        job.setKey(new JobKey(remind.getClass().getSimpleName() + "-" + remind.getId(), jobClass.getSimpleName()));
        job.setRemind(remind);
        job.setRemindService(remindService);
        JobDataMap dataMap = new JobDataMap();
        dataMap.put("jobLimit", new JobLimit(remind.getBeginTime(), remind.getEndTime(), remind.getTotalTimes() == 0 ? 0 : remind.getTotalTimes() - remind.getRemindedTimes()));
        job.setJobDataMap(dataMap);
        return job;
    }

    public void scheduleRemindJob(Remind remind) {
        try {
            scheduler.scheduleJob(buildJobDetail(RemindJob.class, remind), newTrigger().withSchedule(cronSchedule(remind.getCronExpression()).inTimeZone(TimeZone.getTimeZone("GMT+8"))).build());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
