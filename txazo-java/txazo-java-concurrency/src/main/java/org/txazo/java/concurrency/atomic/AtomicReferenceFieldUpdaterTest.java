package org.txazo.java.concurrency.atomic;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * 原子操作类－AtomicReferenceFieldUpdater
 *
 * @author xiaozhou.tu
 * @date 2015-10-20
 * @see AtomicReferenceFieldUpdater
 * @see AtomicReferenceFieldUpdater#newUpdater(Class, Class, String)
 * @see AtomicReferenceFieldUpdater.AtomicReferenceFieldUpdaterImpl
 * @see AtomicReferenceFieldUpdater.AtomicReferenceFieldUpdaterImpl#offset
 * @see AtomicReferenceFieldUpdater.AtomicReferenceFieldUpdaterImpl#tclass
 * @see AtomicReferenceFieldUpdater.AtomicReferenceFieldUpdaterImpl#vclass
 */
public class AtomicReferenceFieldUpdaterTest {

    @Test
    public void test() {
        Entity entity = new Entity(null);
        AtomicReferenceFieldUpdater<Entity, String> fieldUpdater = AtomicReferenceFieldUpdater.newUpdater(Entity.class, String.class, "value");
        fieldUpdater.set(entity, "root");
        Assert.assertEquals("root", entity.getValue());
        Assert.assertTrue(fieldUpdater.compareAndSet(entity, "root", "admin"));
        Assert.assertEquals("admin", entity.getValue());
    }

    private static class Entity {

        public volatile String value;

        public Entity(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

}
