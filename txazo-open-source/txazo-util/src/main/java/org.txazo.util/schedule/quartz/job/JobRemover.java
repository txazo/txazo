package org.txazo.util.schedule.quartz.job;

/**
 * JobRemover
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 15.07.2015
 */
public interface JobRemover<V> extends Value<V> {

    public boolean canRemove(V v);

}
