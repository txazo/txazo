package org.txazo.util.schedule.quartz;

import org.quartz.*;

/**
 * DefaultQuartzScheduler
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 17.07.2015
 */
public class DefaultQuartzScheduler implements QuartzScheduler {

    private Scheduler scheduler;

    public DefaultQuartzScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public boolean addSchedule(JobDetail jobDetail, Trigger trigger) {
        try {
            scheduler.scheduleJob(jobDetail, trigger);
            return true;
        } catch (SchedulerException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteSchedule(JobKey jobKey) {
        try {
            scheduler.deleteJob(jobKey);
            return true;
        } catch (SchedulerException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteSchedule(TriggerKey triggerKey) {
        try {
            scheduler.unscheduleJob(triggerKey);
            return true;
        } catch (SchedulerException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateSchedule(JobDetail jobDetail) {
        try {
            scheduler.addJob(jobDetail, true);
            return true;
        } catch (SchedulerException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

}
