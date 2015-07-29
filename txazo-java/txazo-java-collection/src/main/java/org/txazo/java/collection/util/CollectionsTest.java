package org.txazo.java.collection.util;

import org.junit.Test;

import java.util.*;

/**
 * CollectionsTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.util.Collections
 * @since 29.07.2015
 */
public class CollectionsTest {

    @Test
    public void test() {
        /** 空集合 */
        List list = Collections.EMPTY_LIST;
        Set set = Collections.EMPTY_SET;
        Map map = Collections.EMPTY_MAP;

        /** List排序 */
        Collections.sort(list);
        Collections.sort(list, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }

        });
    }

    /**
     * 集合同步
     *
     * 原理: final Object mutex, synchronized对象锁
     */
    @Test
    public void testSynchronized() {
        Collections.synchronizedList(new ArrayList<Object>());
        Collections.synchronizedSet(new HashSet<Object>());
        Collections.synchronizedMap(new HashMap<Object, Object>());
    }

}
