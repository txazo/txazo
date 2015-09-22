package org.txazo.java.concurrency.base;

import sun.misc.Unsafe;

/**
 * AtomicIntegerJdk7
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 25.07.2015
 */
public class AtomicIntegerJdk7 {

    private static final long valueOffset;
    private static final Unsafe unsafe = Unsafe.getUnsafe();

    static {
        try {
            valueOffset = unsafe.objectFieldOffset(AtomicIntegerJdk7.class.getDeclaredField("value"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    private volatile int value;

    public AtomicIntegerJdk7() {
    }

    public AtomicIntegerJdk7(int initialValue) {
        value = initialValue;
    }

    public final int get() {
        return value;
    }

    public final void set(int newValue) {
        value = newValue;
    }

    public final int incrementAndGet() {
//        return unsafe.getAndAddInt(this, valueOffset, 1) + 1;
        return 0;
    }

}
