package org.txazo.reflection.type;

import org.txazo.test.SuiteTest;
import org.txazo.test.annotation.Test;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

/**
 * TypeVariable - 泛型参数
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.lang.reflect.TypeVariable
 * @since 01.06.2015
 */
public class TypeVariableTest extends SuiteTest {

    private interface MyInterface<T extends List & Serializable, K> {

    }

    private class MyClass<T extends List & Serializable, K> implements MyInterface<T, K> {

        private T t;

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }

    }

    private void assertT(TypeVariable t) {
        /** 泛型参数名称 */
        assertEquals("T", t.getName());
        /** 泛型的父类型  */
        assertSame(List.class, t.getBounds()[0]);
        assertSame(Serializable.class, t.getBounds()[1]);
        /** 泛型声明的类 */
        assertSame(TypeVariableTest.MyClass.class, t.getGenericDeclaration());
    }

    @Test
    public void test1() {
        TypeVariable[] typeVariables = MyClass.class.getTypeParameters();
        assertEquals(2, typeVariables.length);
        assertT(typeVariables[0]);
    }

    @Test
    public void test2() throws NoSuchFieldException {
        Type type = MyClass.class.getDeclaredField("t").getGenericType();
        assertTrue(type instanceof TypeVariable);
        assertT((TypeVariable) type);
    }

    @Test
    public void test3() throws NoSuchMethodException {
        Type type = MyClass.class.getMethod("getT").getGenericReturnType();
        assertTrue(type instanceof TypeVariable);
        assertT((TypeVariable) type);
    }

    @Test
    public void test4() throws NoSuchMethodException {
        Type[] types = MyClass.class.getMethod("setT", List.class).getGenericParameterTypes();
        assertTrue(types[0] instanceof TypeVariable);
        assertT((TypeVariable) types[0]);
    }

}
