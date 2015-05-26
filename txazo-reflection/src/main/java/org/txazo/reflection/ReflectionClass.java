package org.txazo.reflection;


import org.txazo.reflection.vo.Reflect;
import org.txazo.test.SuiteTest;
import org.txazo.test.annotation.Test;

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
        assertSame(r1, r2);
        assertSame(r1, r4);

        /** 基本数据类型的class */
        Field field = r1.getDeclaredField("id");
        assertSame(field.getType(), int.class);
    }

    @Test
    public void test2() {
        Class<?> clazz = Reflect.class;
        /** 类名 */
        assertEquals("Reflect", clazz.getSimpleName());
        /** 全限定类名 */
        assertEquals("org.txazo.reflection.vo.Reflect", clazz.getName());
        /** 修饰符 */
        assertTrue(Modifier.isPublic(clazz.getModifiers()));
        /** 包信息 */
        Package pkg = clazz.getPackage();
        assertEquals("org.txazo.reflection.vo", pkg.getName());

        Class<?>[] classes = clazz.getInterfaces();
    }

}
