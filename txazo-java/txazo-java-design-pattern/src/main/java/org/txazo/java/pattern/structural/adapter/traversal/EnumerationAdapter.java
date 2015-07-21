package org.txazo.java.pattern.structural.adapter.traversal;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * EnumerationAdapter
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class EnumerationAdapter<E> implements Iterator<E> {

    private Enumeration<E> enumeration;

    public EnumerationAdapter(Enumeration<E> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public E next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
    }

}
