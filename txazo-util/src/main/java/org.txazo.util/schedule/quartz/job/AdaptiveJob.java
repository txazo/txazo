package org.txazo.util.schedule.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

/**
 * AdaptiveJob
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 15.07.2015
 */
public abstract class AdaptiveJob<V> implements Job, JobInterceptor, JobRemover {

    private boolean beforeExecute(V value) {
        return !canRemove(value) && canExecute(value);
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataWrapper<V> jobDataWrapper = (JobDataWrapper) context.getJobDetail();
        V value = jobDataWrapper.getValue();
        JobCallback<V> jobCallback = jobDataWrapper.getCallback();
        if (beforeExecute(value)) {
            try {
                jobCallback.callback(value);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
        if (canRemove(value)) {
            try {
                context.getScheduler().deleteJob(context.getJobDetail().getKey());
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }
    }

}
