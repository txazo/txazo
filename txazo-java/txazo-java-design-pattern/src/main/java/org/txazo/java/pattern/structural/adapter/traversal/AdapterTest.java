package org.txazo.java.pattern.structural.adapter.traversal;

import org.junit.Test;

import java.util.*;

/**
 * AdapterTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class AdapterTest {

    @Test
    public void testIteratorAdapter() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (Enumeration<Integer> enumeration = new IteratorAdapter<Integer>(list.iterator()); enumeration.hasMoreElements(); ) {
            System.out.println(enumeration.nextElement());
        }
    }

    @Test
    public void testEnumerationAdapter() {
        Properties prop = new Properties();
        for (int i = 0; i < 10; i++) {
            prop.put(i, i);
        }

        for (Iterator<Object> iterator = new EnumerationAdapter<Object>(prop.elements()); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }

}
