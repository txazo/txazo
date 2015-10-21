/**
 * 原子操作类
 * <p/>
 * 1) 基本类型和引用类型: AtomicBoolean, AtomicInteger, AtomicLong, AtomicReference
<<<<<<< HEAD
 * 2) 字段类型: AtomicIntegerFieldUpdater, AtomicLongFieldUpdater, AtomicReferenceFieldUpdater
=======
 * 2) 对象字段类型: AtomicIntegerFieldUpdater, AtomicLongFieldUpdater, AtomicReferenceFieldUpdater
>>>>>>> f65d91ce22ad5c4fa957fcac6fe4522069da3e87
 * 3) 数组类型: AtomicIntegerArray, AtomicLongArray, AtomicReferenceArray
 * 4) 实现原理: Unsafe, 获取内存偏移, 传入对象和内存偏移进行操作
 * <p/>
 */
package org.txazo.java.concurrency.atomic;