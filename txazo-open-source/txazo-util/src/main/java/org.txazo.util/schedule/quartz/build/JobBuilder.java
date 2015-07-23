package org.txazo.util.schedule.quartz.build;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.txazo.util.schedule.quartz.job.JobAdapter;
import org.txazo.util.schedule.quartz.job.JobCallback;
import org.txazo.util.schedule.quartz.job.JobData;
import org.txazo.util.schedule.quartz.job.JobDetailAdapter;

/**
 * JobBuilder
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 16.07.2015
 */
public abstract class JobBuilder {

    public static <V> JobDetail newJobDetail(String jobName, Class<? extends JobAdapter> jobClass, JobData<V> jobData, JobCallback<V> jobCallback) {
        return newJobDetail(KeyBuilder.newJobKey(jobName, jobClass), jobClass, jobData, jobCallback);
    }

    public static <V> JobDetail newJobDetail(JobKey jobKey, Class<? extends JobAdapter> jobClass, JobData<V> jobData, JobCallback<V> jobCallback) {
        return new JobDetailAdapter(jobKey, jobClass, jobData, jobCallback);
    }

}
