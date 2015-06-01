package org.txazo.reflection.type;

import org.txazo.test.SuiteTest;
import org.txazo.test.annotation.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * ParameterizedType - 参数化类型
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.lang.reflect.ParameterizedType
 * @since 01.06.2015
 */
public class ParameterizedTypeTest extends SuiteTest {

    private abstract class AbstractClass<K, V> {

    }

    private class MyClass extends AbstractClass<String, Integer> {

    }

    @Test
    public void test1() {
        Type type = MyClass.class.getGenericSuperclass();
        assertTrue(type instanceof ParameterizedType);
        ParameterizedType pType = (ParameterizedType) type;
        assertSame(String.class, pType.getActualTypeArguments()[0]);
        assertSame(Integer.class, pType.getActualTypeArguments()[1]);
        assertSame(ParameterizedTypeTest.class, pType.getOwnerType());
        assertSame(ParameterizedTypeTest.AbstractClass.class, pType.getRawType());
    }

}
