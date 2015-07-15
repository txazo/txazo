package org.txazo.util.schedule.quartz.job;

/**
 * JobInterceptor
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 15.07.2015
 */
public interface JobInterceptor<V> {

    public boolean canExecute(V v);

}
