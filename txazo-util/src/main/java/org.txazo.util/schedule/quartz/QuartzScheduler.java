package org.txazo.util.schedule.quartz;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Trigger;
import org.quartz.TriggerKey;

/**
 * QuartzScheduler
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 15.07.2015
 */
public interface QuartzScheduler {

    public boolean addSchedule(JobDetail jobDetail, Trigger trigger);

    public boolean deleteSchedule(JobKey jobKey);

    public boolean deleteSchedule(TriggerKey triggerKey);

    public boolean updateSchedule(JobDetail jobDetail);

}
