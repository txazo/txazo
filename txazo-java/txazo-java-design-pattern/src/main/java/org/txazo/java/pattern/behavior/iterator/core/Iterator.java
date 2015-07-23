package org.txazo.java.pattern.behavior.iterator.core;

/**
 * Iterator
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public interface Iterator<E> {

    public E first();

    public E last();

    public E next();

    public boolean hasNext();

    public void remove();

}
