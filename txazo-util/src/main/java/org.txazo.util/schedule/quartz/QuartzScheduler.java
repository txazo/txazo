package org.txazo.util.schedule.quartz;

import org.quartz.JobKey;
import org.txazo.util.schedule.quartz.job.JobCallback;

/**
 * QuartzScheduler
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 15.07.2015
 */
public interface QuartzScheduler {

    public <V> void addSchedule(JobKey jobKey, V v, JobCallback<V> jobCallback);

}
