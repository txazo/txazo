package org.txazo.java.collection.map;

/**
 * HashMapTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.util.HashMap
 * @since 30.07.2015
 */
public class HashMapTest {

    /**
     * HashMap
     *
     * 1) 非线程安全, key和value都可为null
     * 2) 实现: Entry数组 + Entry链表, 拉链法
     * 3) Entry: HashMap.Entry(hash key value next)
     * 4) 原理: key - hash() - hash - index - Entry[index] - Entry - Entry.key - (key == Entry.key || key.equals(Entry.key))
     * 5) 扩容: 默认容量16, 容量超过capacity * loadFactor时扩容一倍(2的倍数), 创建时可设置初始容量(实际初始容量为不小于初始容量的最小2的n次幂), 避免频繁扩容
     * 6) 重散列: 扩容时由于length扩大一倍, 需要重新计算index
     * 7) Fail-Fast机制: 对HashMap进行迭代时, 除了迭代器的remove(), 其它任何对HashMap结构的修改都会抛出ConcurrentModificationException
     */

}
