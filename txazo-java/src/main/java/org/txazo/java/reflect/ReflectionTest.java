package org.txazo.java.reflect;

import org.junit.Assert;
import org.junit.Test;

public class ReflectionTest {

    @Test
    public void test() throws ClassNotFoundException {
        Class<?> reflectionVoClass1 = ReflectionVo.class;
        Class<?> reflectionVoClass2 = new ReflectionVo().getClass();
        Class<?> reflectionVoClass3 = Class.forName("org.txazo.java.reflect.ReflectionVo");
        Class<?> reflectionVoClass4 = Thread.currentThread().getContextClassLoader().loadClass("org.txazo.java.reflect.ReflectionVo");

        Assert.assertSame(reflectionVoClass1, reflectionVoClass2);
        Assert.assertSame(reflectionVoClass1, reflectionVoClass3);
        Assert.assertSame(reflectionVoClass1, reflectionVoClass4);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        new ReflectionTest().test();
    }

}
