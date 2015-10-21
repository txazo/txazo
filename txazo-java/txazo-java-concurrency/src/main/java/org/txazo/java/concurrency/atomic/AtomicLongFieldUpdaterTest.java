package org.txazo.java.concurrency.atomic;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/**
 * 原子操作类－AtomicLongFieldUpdater
 *
 * @author xiaozhou.tu
 * @date 2015-10-20
 * @see AtomicLongFieldUpdater
 * @see AtomicLongFieldUpdater#newUpdater(Class, String)
 * @see AtomicLongFieldUpdater.CASUpdater
 * @see AtomicLongFieldUpdater.LockedUpdater
 * @see AtomicLongFieldUpdater.LockedUpdater#offset
 * @see AtomicLongFieldUpdater.LockedUpdater#tclass
 */
public class AtomicLongFieldUpdaterTest {

    @Test
    public void test() {
        Entity entity = new Entity(1);
        AtomicLongFieldUpdater fieldUpdater = AtomicLongFieldUpdater.newUpdater(Entity.class, "value");
        Assert.assertEquals(1, entity.getValue());
        fieldUpdater.set(entity, 10);
        Assert.assertEquals(10, entity.getValue());
        Assert.assertTrue(fieldUpdater.compareAndSet(entity, 10, 100));
        Assert.assertEquals(100, entity.getValue());
    }

    private static class Entity {

        public volatile long value;

        public Entity(long value) {
            this.value = value;
        }

        public long getValue() {
            return value;
        }

    }

}
