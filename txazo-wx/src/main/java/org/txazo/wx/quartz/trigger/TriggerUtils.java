package org.txazo.wx.quartz.trigger;

import org.quartz.CronScheduleBuilder;
import org.quartz.TriggerBuilder;
import org.txazo.wx.app.remind.bean.Remind;

/**
 * TriggerUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 11.06.2015
 */
public abstract class TriggerUtils {

    public void newCronTrigger(Remind remind) {
        TriggerBuilder.newTrigger()
                .withIdentity("")
                .forJob("")
                .withSchedule(CronScheduleBuilder.cronSchedule("").dailyAtHourAndMinute(1, 1).cronSchedule(""))
                .build();
    }

}
