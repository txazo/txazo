package org.txazo.java.collection.iterator;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Vector;

/**
 * EnumerationTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.util.Enumeration
 * @since 30.07.2015
 */
public class EnumerationTest {

    /**
     * Enumeration
     *
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
