package org.txazo.java.pattern.structural.adapter.traversal;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * EnumerationAdapter - Iterator到Enumeration的适配
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class IteratorAdapter<E> implements Enumeration<E> {

    private Iterator<E> iterator;

    public IteratorAdapter(Iterator<E> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public E nextElement() {
        return iterator.next();
    }

}
