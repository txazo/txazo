package org.txazo.reflection;

import org.apache.commons.lang3.ArrayUtils;
import org.txazo.reflection.anno.ClassAnno;
import org.txazo.reflection.vo.Reflect;
import org.txazo.reflection.vo.ReflectInterface;
import org.txazo.reflection.vo.SuperInterface;
import org.txazo.reflection.vo.SuperReflect;
import org.txazo.test.SuiteTest;
import org.txazo.test.annotation.Test;

import java.lang.reflect.Modifier;
import java.util.*;

/**
 * ReflectionClass
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.lang.Class
 * @since 13.05.2015
 */
public class ReflectionClass extends SuiteTest {

    private class InnerClass {

    }

    @Test
    public void test1() throws ClassNotFoundException, NoSuchFieldException {
        /** class对象的获取 */

        /** 对象、原始数据类型、void、Void */
        assertNotNull(Reflect.class);
        /** 原始数据类型的包装类 Void */
        assertSame(int.class, Integer.TYPE);
        /** 对象的getClass() */
        assertSame(Reflect.class, new Reflect().getClass());
        /** Class.forName() */
        assertSame(Reflect.class, Class.forName("org.txazo.reflection.vo.Reflect"));
        /** ClassLoader的loadClass() */
        assertSame(Reflect.class, Thread.currentThread().getContextClassLoader().loadClass("org.txazo.reflection.vo.Reflect"));
        /** 父类class */
        assertSame(AbstractList.class, ArrayList.class.getSuperclass());
        /** 外部类class */
        assertSame(ReflectionClass.class, ReflectionClass.InnerClass.class.getEnclosingClass());
        /** 内部类class(public、递归继承) */
        assertTrue(ArrayUtils.isEmpty(ReflectionClass.class.getClasses()));
        /** 内部类class(private、不可继承) */
        assertSame(ReflectionClass.InnerClass.class, ReflectionClass.class.getDeclaredClasses()[0]);
    }

    @Test
    public void test2() {
        Class<?> clazz = Reflect.class;
        /** 包名 */
        assertEquals("org.txazo.reflection.vo", clazz.getPackage().getName());
        /** 类注解 */
        assertTrue(clazz.isAnnotationPresent(ClassAnno.class));
        /** 修饰符 */
        assertTrue(Modifier.isPublic(clazz.getModifiers()));
        /** 类名 */
        assertEquals("Reflect", clazz.getSimpleName());
        /** 全限定类名 */
        assertEquals("org.txazo.reflection.vo.Reflect", clazz.getName());
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
        /** asSubclass */
        Class<? extends SuperReflect> clazz = Class.forName("org.txazo.reflection.vo.Reflect").asSubclass(SuperReflect.class);
        assertNotNull(clazz);
    }

    @Test
    public void test5() {
        /** getName、getSimpleName、getCanonicalName */
        assertClassName(int.class, "int", "int", "int");
        assertClassName(int[].class, "[I", "int[]", "int[]");
        assertClassName(int[][].class, "[[I", "int[][]", "int[][]");
        assertClassName(Reflect.class, "org.txazo.reflection.vo.Reflect", "Reflect", "org.txazo.reflection.vo.Reflect");
        assertClassName(Reflect[].class, "[Lorg.txazo.reflection.vo.Reflect;", "Reflect[]", "org.txazo.reflection.vo.Reflect[]");
        assertClassName(Reflect[][].class, "[[Lorg.txazo.reflection.vo.Reflect;", "Reflect[][]", "org.txazo.reflection.vo.Reflect[][]");
    }

    private void assertClassName(Class<?> clazz, String name, String simpleName, String canonicalName) {
        assertEquals(name, clazz.getName());
        assertEquals(simpleName, clazz.getSimpleName());
        assertEquals(canonicalName, clazz.getCanonicalName());
    }

}
