package org.txazo.reflection.type;

import org.txazo.test.SuiteTest;
import org.txazo.test.annotation.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;

/**
 * ParameterizedType - 参数化类型
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.lang.reflect.ParameterizedType
 * @since 01.06.2015
 */
public class ParameterizedTypeTest extends SuiteTest {

    private interface Interface<T> {

        public T method();

    }

    private abstract class AbstractClass<T> implements Interface<T> {

    }

    private class MyClass<T, K> extends AbstractClass<T> implements Interface<T> {

        @Override
        public T method() {
            return null;
        }

    }

    @Test
    public void test1() {
        MyClass<Integer, String> myClass = new MyClass<Integer, String>();

        TypeVariable<? extends Class<? extends MyClass>>[] typeVariables = myClass.getClass().getTypeParameters();

        ParameterizedType pt = (ParameterizedType) myClass.getClass().getGenericSuperclass();
        Class<?> clazz = (Class) pt.getActualTypeArguments()[0];
        println(clazz.getName());
    }

}
