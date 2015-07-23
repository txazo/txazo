package org.txazo.wx.app.remind.job;

import org.txazo.util.schedule.quartz.job.JobAdapter;

/**
 * RemindJob
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 15.07.2015
 */
public class RemindJob<Remind> extends JobAdapter<Remind> {

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
