package org.txazo.util.schedule.quartz.job;

/**
 * JobData
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 16.07.2015
 */
public class JobData<V> implements Value<V> {

    private V value;

    public JobData(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

}
