package org.txazo.wx.quartz.job;

import org.quartz.*;
import org.txazo.wx.quartz.bean.JobLimit;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * TimeLimitJob
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 11.06.2015
 */
public abstract class LimitJob implements Job {

    private Map<JobExecutionContext, AtomicInteger> executeTimes = new ConcurrentHashMap<JobExecutionContext, AtomicInteger>();

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        if (canExecute(context)) {
            try {
                executeJob(context);
            } catch (Throwable t) {
                t.printStackTrace();
            } finally {
                increaseTimes(context);
            }
        }
    }

    private boolean canExecute(JobExecutionContext context) {
        JobLimit limit = null;
        JobDataMap dataMap = context.getMergedJobDataMap();
        if (dataMap == null || (limit = (JobLimit) dataMap.get("jobLimit")) == null) {
            return true;
        }
        try {
            Date now = new Date();
            if (limit.getBeginTime() != null && limit.getBeginTime().after(now)) {
                return false;
            }
            if (limit.getEndTime() != null && limit.getEndTime().before(now)) {
                return false;
            }
            return limit.getTotalTimes() == 0 || (limit.getTotalTimes() > getTimes(context));
        } catch (Exception e) {
            return false;
        }
    }

    private int getTimes(JobExecutionContext context) {
        AtomicInteger times = executeTimes.get(context);
        if (times == null) {
            times = new AtomicInteger(0);
            executeTimes.put(context, times);
        }
        return times.get();
    }

    private void increaseTimes(JobExecutionContext context) {
        AtomicInteger times = executeTimes.get(context);
        if (times == null) {
            times = new AtomicInteger(0);
        }
        times.incrementAndGet();
        executeTimes.put(context, times);
    }

    protected abstract void executeJob(JobExecutionContext context) throws Throwable;

}
