package org.txazo.util.schedule.quartz.job;

import org.quartz.JobKey;
import org.quartz.impl.JobDetailImpl;

/**
 * JobDataWrapper
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 15.07.2015
 */
public class JobDataWrapper<V> extends JobDetailImpl {

    private V value;
    private JobCallback<V> callback;

    public JobDataWrapper(JobKey jobKey, Class<AdaptiveJob<?>> jobClass, V value, JobCallback<V> callback) {
        this.value = value;
        this.callback = callback;
        setKey(jobKey);
        setJobClass(jobClass);
//        JobDataMap jobDataMap = new JobDataMap();
//        jobDataMap.put("value", value);
//        jobDataMap.put("callback", callback);
//        setJobDataMap(jobDataMap);
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public JobCallback<V> getCallback() {
        return callback;
    }

    public void setCallback(JobCallback<V> callback) {
        this.callback = callback;
    }

}
