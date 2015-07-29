package org.txazo.java.collection.list;

/**
 * CopyOnWriteArrayListTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.util.concurrent.CopyOnWriteArrayList
 * @since 29.07.2015
 */
public class CopyOnWriteArrayListTest {

    /**
     * CopyOnWriteArrayList
     *
     * 1) 线程安全
     * 2) 读写分离, 读不加锁, 写加锁ReentrantLock + volatile
     * 3) 适合读多写少的并发场景
     * 4) 尽量批量添加, 初始化大小减少扩容
     * 5) 迭代器Iterator是线程安全的, 因为数组元素不会被修改
     * 6) 缺点:
     *    1) 内存占用: 两个数组对象, 数组占用内存较大时, 可能造成频繁的GC
     *    2) 数据一致性: 保证数据的最终一致性, 但不保证数据的实时一致性
     */

}
