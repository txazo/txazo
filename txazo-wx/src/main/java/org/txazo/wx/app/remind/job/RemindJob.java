package org.txazo.wx.app.remind.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.PersistJobDataAfterExecution;
import org.txazo.util.schedule.quartz.job.JobAdapter;

/**
 * RemindJob
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 15.07.2015
 */
@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class RemindJob<Remind> extends JobAdapter<Remind> implements Job {

    @Override
    public boolean canExecute(Remind remind) {
        System.out.println("RemindJob canExecute");
        return true;
    }

    @Override
    public boolean canRemove(Remind remind) {
        System.out.println("RemindJob canRemove");
        return false;
    }

}
