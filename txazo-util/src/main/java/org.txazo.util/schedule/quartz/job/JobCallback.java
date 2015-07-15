package org.txazo.util.schedule.quartz.job;

/**
 * JobCallback
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 15.07.2015
 */
public interface JobCallback<V> {

    public void callback(V v);

}
