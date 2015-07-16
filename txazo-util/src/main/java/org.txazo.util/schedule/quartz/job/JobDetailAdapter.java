package org.txazo.util.schedule.quartz.job;

import org.quartz.Job;
import org.quartz.JobKey;
import org.quartz.impl.JobDetailImpl;

/**
 * JobDetailAdapter
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 15.07.2015
 */
public class JobDetailAdapter<V> extends JobDetailImpl implements Value<V> {

    private static final long serialVersionUID = 5296184612540623850L;

    private JobData<V> jobData;
    private JobCallback<V> jobCallback;

    public JobDetailAdapter(JobKey jobKey, Class<? extends Job> jobClass, JobData<V> jobData, JobCallback<V> jobCallback) {
        this.jobData = jobData;
        this.jobCallback = jobCallback;
        setKey(jobKey);
        setJobClass(jobClass);
    }

    public JobCallback<V> getJobCallback() {
        return jobCallback;
    }

    public void setJobCallback(JobCallback<V> jobCallback) {
        this.jobCallback = jobCallback;
    }

    public JobData<V> getJobData() {
        return jobData;
    }

    public void setJobData(JobData<V> jobData) {
        this.jobData = jobData;
    }

}
