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

    private boolean beforeExecute(V v) {
        return !canRemove(v) && canExecute(v);
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        V v = (V) context.getMergedJobDataMap().get("V");
        if (beforeExecute(v)) {
            try {
                executeJob(v);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
        if (canRemove(v)) {
            try {
                context.getScheduler().deleteJob(context.getJobDetail().getKey());
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
        }
    }

    protected abstract void executeJob(V v) throws Throwable;

}
