package org.txazo.util.schedule.quartz.build;

import org.quartz.JobKey;
import org.quartz.TriggerKey;
import org.txazo.util.schedule.quartz.job.JobAdapter;

/**
 * KeyBuilder
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 16.07.2015
 */
public abstract class KeyBuilder {

    public static JobKey newJobKey(String name, Class<? extends JobAdapter> clazz) {
        return newJobKey(name, clazz.getSimpleName());
    }

    public static JobKey newJobKey(String name, String group) {
        return JobKey.jobKey(name, group);
    }

    public static TriggerKey newTriggerKey(String name, Class<? extends JobAdapter> clazz) {
        return newTriggerKey(name, clazz.getSimpleName());
    }

    public static TriggerKey newTriggerKey(String name, String group) {
        return TriggerKey.triggerKey(name, group);
    }

}
