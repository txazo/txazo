package org.txazo.java.pattern.creational.singleton.core;

import org.junit.Assert;
import org.junit.Test;

/**
 * SingletonTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.07.2015
 */
public class SingletonTest {

    @Test
    public void testLazySingleton() {
        Assert.assertSame(LazySingleton.getInstance(), LazySingleton.getInstance());
    }

    @Test
    public void testHungrySingleton() {
        Assert.assertSame(HungrySingleton.getInstance(), HungrySingleton.getInstance());
    }

    public void testDoubleCheckLockingSingleton() {
        Assert.assertSame(DoubleCheckLockingSingleton.getInstance(), DoubleCheckLockingSingleton.getInstance());
    }

    @Test
    public void testStaticInnerClassSingleton() {
        Assert.assertSame(StaticInnerClassSingleton.getInstance(), StaticInnerClassSingleton.getInstance());
    }

    @Test
    public void testEnumSingleton() {
        Assert.assertSame(EnumSingleton.getInstance(), EnumSingleton.getInstance());
    }

}
