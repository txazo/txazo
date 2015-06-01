package org.txazo.reflection.type;

import org.txazo.test.SuiteTest;
import org.txazo.test.annotation.Test;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/**
 * GenericArrayType - 数组类型参数
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.lang.reflect.GenericArrayType
 * @since 01.06.2015
 */
public class GenericArrayTypeTest extends SuiteTest {

    private interface MyInterface<T> {

    }

    private class MyClass<T> implements MyInterface<T> {

        private T[] array;

        public T[] getArray() {
            return array;
        }

        public void setArray(T[] array) {
            this.array = array;
        }
    }

    @Test
    public void test1() throws NoSuchFieldException {
        Type type = MyClass.class.getDeclaredField("array").getGenericType();
        assertTrue(type instanceof GenericArrayType);
        GenericArrayType arrayType = (GenericArrayType) type;
        Type cType = arrayType.getGenericComponentType();
        assertTrue(cType instanceof TypeVariable);
        TypeVariable vType = (TypeVariable) cType;
        assertEquals("T", vType.getName());
        assertSame(Object.class, vType.getBounds()[0]);
        assertSame(GenericArrayTypeTest.MyClass.class, vType.getGenericDeclaration());
    }

}
