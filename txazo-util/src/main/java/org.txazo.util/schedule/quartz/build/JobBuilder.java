package org.txazo.util.schedule.quartz.build;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.txazo.util.schedule.quartz.job.AdaptiveJob;
import org.txazo.util.schedule.quartz.job.JobCallback;
import org.txazo.util.schedule.quartz.job.JobDataWrapper;

/**
 * JobBuilder
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 16.07.2015
 */
public abstract class JobBuilder {

    public static JobKey getJobKey(String jobName, String jobGroup) {
        return new JobKey(jobName, jobGroup);
    }

    public static <V> JobDetail buildJobDetail(JobKey jobKey, Class<AdaptiveJob<?>> jobClass, V value, JobCallback<V> callback) {
        return new JobDataWrapper(jobKey, jobClass, value, callback);
    }

}
