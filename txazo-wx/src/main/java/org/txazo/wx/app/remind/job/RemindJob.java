package org.txazo.wx.app.remind.job;

import org.txazo.util.schedule.quartz.CronUtils;
import org.txazo.util.schedule.quartz.job.AdaptiveJob;
import org.txazo.wx.app.remind.bean.Remind;

import java.util.Date;

/**
 * RemindJob
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 15.07.2015
 */
public class RemindJob extends AdaptiveJob<Remind> {

    @Override
    protected void executeJob(Remind remind) throws Throwable {

    }

    @Override
    public boolean canExecute(Remind remind) {
        return remind.getExt().getBeginTime() == null ||
                remind.getExt().getBeginTime().before(new Date());
    }

    @Override
    public boolean isExpire(Remind remind) {
        return remind == null || remind.getExt() == null ||
                CronUtils.isExpire(remind.getExt().getCronExpression()) ||
                (remind.getExt().getEndTime() != null && remind.getExt().getEndTime().before(new Date()));
    }

}
