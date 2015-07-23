package org.txazo.util.schedule.quartz.build;

import org.quartz.Trigger;
import org.quartz.TriggerKey;

import java.util.TimeZone;

import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.CronScheduleBuilder.cronSchedule;

/**
 * TriggerBuilder
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 16.07.2015
 */
public abstract class TriggerBuilder {

    public static Trigger newCronTrigger(String expression, TriggerKey triggerKey) {
        return newTrigger()
                .withIdentity(triggerKey)
                .withSchedule(cronSchedule(expression).inTimeZone(TimeZone.getTimeZone("GMT+8")))
                .build();
    }

}
