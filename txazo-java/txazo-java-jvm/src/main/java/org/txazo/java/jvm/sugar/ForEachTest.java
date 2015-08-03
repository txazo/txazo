package org.txazo.java.jvm.sugar;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ForEachTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.08.2015
 */
public class ForEachTest {

    /**
     * 增强for循环语法糖
     *
     * 1) foreach内部原理: Iterator
     */

    @Test
    public void test() {
        int number = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (Integer i : list) {
            number = i;
        }
    }

    @Test
    public void testDecompile() {
        int number = 0;
        List list = new ArrayList();
        for (Iterator i = list.iterator(); i.hasNext(); ) {
            number = ((Integer) i.next()).intValue();
        }
    }

}
