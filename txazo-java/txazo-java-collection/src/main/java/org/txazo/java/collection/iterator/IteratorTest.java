package org.txazo.java.collection.iterator;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * IteratorTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.util.Iterator
 * @since 30.07.2015
 */
public class IteratorTest {

    /**
     * Iterator
     * <p/>
     * 1) 迭代器
     * 2) 迭代器模式
     * 3) remove()是安全的
     */

    @Test
    public void test() {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (Iterator<Integer> i = list.iterator(); i.hasNext(); ) {
            System.out.println(i.next());
        }
    }

}
