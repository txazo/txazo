package org.txazo.java.collection.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ListTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.util.List
 * @since 28.07.2015
 */
public class ListTest {

    @Test
    public void test() {
        List<Integer> list = new ArrayList<Integer>();

        /** List遍历方式一 */
        for (int i = 0, length = list.size(); i < length; i++) {
            System.out.println(list.get(i));
        }

        /** List遍历方式二, 内部实现为Iterator */
        for (Integer i : list) {
            System.out.println(i);
        }

        /** List遍历方式三 */
        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }

        /** List遍历方式四 */
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
