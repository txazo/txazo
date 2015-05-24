package org.txazo.reflection;

import org.junit.Assert;
import org.junit.Test;
import org.txazo.reflection.vo.Reflect;
import org.txazo.test.junit4.suite.SuiteTest;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * ReflectionClass
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.lang.Class
 * @since 13.05.2015
 */
public class ReflectionClass extends SuiteTest {

    @Test
    public void test1() throws ClassNotFoundException, NoSuchFieldException {
        /** class对象的获取 */
        Class<?> r1 = Reflect.class;
        Class<?> r2 = new Reflect().getClass();
        Class<?> r3 = Class.forName("org.txazo.reflection.vo.Reflect");
        Class<?> r4 = Thread.currentThread().getContextClassLoader().loadClass("org.txazo.reflection.vo.Reflect");
        Assert.assertSame(r1, r2);
        Assert.assertSame(r1, r4);

        /** 基本数据类型的class */
        Field field = r1.getDeclaredField("id");
        Assert.assertSame(field.getType(), int.class);
    }

    @Test
    public void test2() {
        Class<?> clazz = Reflect.class;
        /** 类名 */
        Assert.assertEquals("Reflect", clazz.getSimpleName());
        /** 全限定类名 */
        Assert.assertEquals("org.txazo.reflection.vo.Reflect", clazz.getName());
        /** 修饰符 */
        Assert.assertTrue(Modifier.isPublic(clazz.getModifiers()));
        /** 包信息 */
        Package pkg = clazz.getPackage();
        Assert.assertEquals("org.txazo.reflection.vo", pkg.getName());

        Class<?>[] classes = clazz.getInterfaces();
    }

}
