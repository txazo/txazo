package org.txazo.reflection;

import org.txazo.reflection.vo.Reflect;
import org.txazo.test.SuiteTest;
import org.txazo.test.annotation.Test;

import java.lang.reflect.Array;

/**
 * ReflectionArray
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.lang.reflect.Array
 * @since 28.05.2015
 */
public class ReflectionArray extends SuiteTest {

    @Test
    public void test1() {
        /** 创建数组 */
        int[] intArray = (int[]) Array.newInstance(int.class, 1);
        intArray[0] = 1;

        /** 数组get */
        assertEquals(1, Array.get(intArray, 0));

        /** 数组set */
        Array.set(intArray, 0, 5);
        assertEquals(5, intArray[0]);
    }

    @Test
    public void test2() throws ClassNotFoundException {
        /** 获取数组class的三种方式 */
        assertEquals(int[].class, Class.forName("[I"));
        assertEquals(int[].class, Array.newInstance(int.class, 0).getClass());

        /** 数组的class name */
        assertEquals("[I", int[].class.getName());
        assertEquals("[Ljava.lang.String;", String[].class.getName());
        assertEquals("[Lorg.txazo.reflection.vo.Reflect;", Reflect[].class.getName());
    }

    @Test
    public void test3() {
        /** 数组的成员类型 */
        Class<?> intArrayClass = int[].class;
        assertEquals(int.class, intArrayClass.getComponentType());
    }

}
