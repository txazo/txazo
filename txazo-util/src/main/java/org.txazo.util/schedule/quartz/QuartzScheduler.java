package org.txazo.util.schedule.quartz;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.txazo.util.schedule.quartz.job.JobDetailAdapter;

/**
 * QuartzScheduler
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 15.07.2015
 */
public interface QuartzScheduler {

    public void addSchedule(JobDetail jobDetail, Trigger trigger);

    public void unSchedule(JobKey jobKey);

    public void unSchedule(TriggerKey triggerKey);

    public <V> void updateSchedule(JobDetailAdapter<V> jobDetailAdapter);

}
