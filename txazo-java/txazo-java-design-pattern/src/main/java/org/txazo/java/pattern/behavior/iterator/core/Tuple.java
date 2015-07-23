package org.txazo.java.pattern.behavior.iterator.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Iterable
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.07.2015
 */
public class Tuple<E> implements Iterable<E> {

    private List<E> elements = new ArrayList<E>();

    public void add(E e) {
        elements.add(e);
    }

    @Override
    public Iterator iterator() {
        return new TupleIterator();
    }

    private class TupleIterator implements Iterator<E> {

        private int current;

        private E get(int index) {
            return index >= 0 && index < elements.size() ? elements.get(index) : null;
        }

        @Override
        public E first() {
            return get(0);
        }

        @Override
        public E last() {
            return get(elements.size() - 1);
        }

        @Override
        public E next() {
            return get(current++);
        }

        @Override
        public boolean hasNext() {
            return current < elements.size();
        }

        @Override
        public void remove() {
            elements.remove(current);
        }

    }

}
