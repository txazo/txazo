package org.txazo.wx.quartz.job;

import org.quartz.impl.JobDetailImpl;
import org.txazo.wx.app.remind.bean.Remind;
import org.txazo.wx.app.remind.service.RemindService;

/**
 * RemindJobDetail
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 11.06.2015
 */
public class RemindJobDetail extends JobDetailImpl {

    private static final long serialVersionUID = 222129509226256297L;

    private Remind remind;
    private RemindService remindService;

    public Remind getRemind() {
        return remind;
    }

    public void setRemind(Remind remind) {
        this.remind = remind;
    }

    public RemindService getRemindService() {
        return remindService;
    }

    public void setRemindService(RemindService remindService) {
        this.remindService = remindService;
    }

}
