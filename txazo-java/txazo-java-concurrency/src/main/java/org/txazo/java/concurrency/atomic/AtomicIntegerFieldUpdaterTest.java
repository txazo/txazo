package org.txazo.java.concurrency.atomic;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 原子操作类－AtomicIntegerFieldUpdater
 *
 * @author xiaozhou.tu
 * @date 2015-10-20
 * @see AtomicIntegerFieldUpdater
 * @see AtomicIntegerFieldUpdater#newUpdater(Class, String)
 * @see AtomicIntegerFieldUpdater.AtomicIntegerFieldUpdaterImpl
 * @see AtomicIntegerFieldUpdater.AtomicIntegerFieldUpdaterImpl#offset
 * @see AtomicIntegerFieldUpdater.AtomicIntegerFieldUpdaterImpl#tclass
 */
public class AtomicIntegerFieldUpdaterTest {

    @Test
    public void test() {
        Entity entity = new Entity(1);
        AtomicIntegerFieldUpdater fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(Entity.class, "value");
        Assert.assertEquals(1, entity.getValue());
        fieldUpdater.set(entity, 10);
        Assert.assertEquals(10, entity.getValue());
        Assert.assertTrue(fieldUpdater.compareAndSet(entity, 10, 100));
        Assert.assertEquals(100, entity.getValue());
    }

    private static class Entity {

        public volatile int value;

        public Entity(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

}
