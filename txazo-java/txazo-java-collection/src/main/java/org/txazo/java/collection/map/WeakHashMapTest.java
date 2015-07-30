package org.txazo.java.collection.map;

/**
 * WeakHashMapTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.util.WeakHashMap
 * @since 30.07.2015
 */
public class WeakHashMapTest {

    /**
     * WeakHashMap
     *
     * 1) key为弱键
     * 2) key不被引用时, 会被GC回收, 同时被添加到ReferenceQueue
     * 3) 操作WeakHashMap时, 同步table和queue, 删除弱键key对应的value
     */

}
