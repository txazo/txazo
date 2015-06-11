package org.txazo.wx.quartz.job;

import org.quartz.*;
import org.txazo.wx.quartz.bean.JobLimit;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TimeLimitJob
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 11.06.2015
 */
public abstract class LimitJob implements Job {

    private Map<JobExecutionContext, Integer> executeTimes = new ConcurrentHashMap<JobExecutionContext, Integer>();

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        if (canExecute(context)) {
            try {
                executeJob(context);
                increaseTimes(context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean canExecute(JobExecutionContext context) {
        JobDataMap dataMap = context.getMergedJobDataMap();
        try {
            Date now = new Date();
            JobLimit limit = (JobLimit) dataMap.get("limit");
            if (limit.getBeginTime() != null && limit.getBeginTime().before(now)) {
                return false;
            }
            if (limit.getEndTime() != null && limit.getEndTime().after(now)) {
                return false;
            }
            Integer times = null;
            return limit.getTotalTimes() == 0 || ((times = executeTimes.get(context)) == null || limit.getTotalTimes() > times);
        } catch (Exception e) {
            return false;
        }
    }

    private void increaseTimes(JobExecutionContext context) {
        Integer times = executeTimes.get(context);
        times = times == null ? 0 : times;
        executeTimes.put(context, times + 1);
    }

    protected abstract void executeJob(JobExecutionContext context) throws Exception;

}
