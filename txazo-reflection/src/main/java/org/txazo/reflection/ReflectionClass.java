package org.txazo.reflection;


import org.apache.commons.lang3.ArrayUtils;
import org.txazo.reflection.vo.Reflect;
import org.txazo.reflection.vo.ReflectInterface;
import org.txazo.reflection.vo.SuperInterface;
import org.txazo.reflection.vo.SuperReflect;
import org.txazo.test.SuiteTest;
import org.txazo.test.annotation.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

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
        assertSame(r1, r3);
        assertSame(r1, r4);

        /** 基本数据类型的class */
        Field field = r1.getDeclaredField("id");
        assertSame(int.class, field.getType());
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
        assertEquals("org.txazo.reflection.vo", clazz.getPackage().getName());
        /** 父类 */
        assertSame(SuperReflect.class, clazz.getSuperclass());
        assertSame(Object.class, clazz.getSuperclass().getSuperclass());
        /** 接口 */
        assertSame(ReflectInterface.class, clazz.getInterfaces()[0]);
        assertSame(SuperInterface.class, clazz.getInterfaces()[0].getInterfaces()[0]);
        assertTrue(ArrayUtils.isEmpty(clazz.getInterfaces()[0].getInterfaces()[0].getInterfaces()));
    }

    @Test
    public void test3() {
        Class<?> clazz = this.getClass();
        /** 当前目录路径 */
        assertTrue(clazz.getResource("").getPath().endsWith("org/txazo/reflection/"));
        /** 当前目录路径 */
        assertTrue(clazz.getResource(".").getPath().endsWith("org/txazo/reflection/"));
        /** 根目录路径 */
        assertTrue(clazz.getResource("/").getPath().endsWith("classes/"));

        /** 读取当前目录下文件 */
        assertNotNull(clazz.getResourceAsStream("package-info.class"));
        /** 读取根目录下文件 */
        assertNotNull(clazz.getResourceAsStream("/reflect.properties"));
    }

    @Test
    public void test4() throws ClassNotFoundException {
        /** 避免产生编译警告 */
        Class<? extends List> subClass = ArrayList.class.asSubclass(List.class);
        assertEquals("java.util.ArrayList", subClass.getCanonicalName());

        Class<? extends SuperReflect> clazz = Class.forName("org.txazo.reflection.vo.Reflect").asSubclass(SuperReflect.class);
        assertNotNull(clazz);
    }

}
