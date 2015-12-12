package org.txazo.java.collection.iterator;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Enumeration
 *
 * @see java.util.Enumeration
 */
public class EnumerationTest {

    /**
     * Enumeration
     * <p/>
     * 迭代器模式
     */

    @Test
    public void test() {
        Vector<Integer> vector = new Vector<Integer>();
        for (int i = 0; i < 10; i++) {
            vector.add(i);
        }

        for (Enumeration<Integer> e = vector.elements(); e.hasMoreElements(); ) {
            System.out.println(e.nextElement());
        }
    }

}
