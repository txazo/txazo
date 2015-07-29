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
        Collections.emptyList();
        Collections.emptySet();
        Collections.emptyMap();

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
     * Collections.synchronizedXXX()
     * <p/>
     * 1) 返回同步的集合包装
     * 2) 原理: final Object mutex, synchronized对象锁
     */
    @Test
    public void testSynchronized() {
        Collections.synchronizedList(new ArrayList<Object>());
        Collections.synchronizedSet(new HashSet<Object>());
        Collections.synchronizedMap(new HashMap<Object, Object>());
    }

    /**
     * Collections.unmodifiableXXX()
     * <p/>
     * 1) 返回不可修改的集合包装
     */
    @Test
    public void testUnmodifiable() {
        Collections.unmodifiableList(new ArrayList<Object>());
    }

    /**
     * Collections.checkedXXX() - 集合元素强制类型检查
     */
    @Test
    public void testC() {
        Collections.checkedList(new ArrayList<Integer>(), Integer.class);
    }

}
