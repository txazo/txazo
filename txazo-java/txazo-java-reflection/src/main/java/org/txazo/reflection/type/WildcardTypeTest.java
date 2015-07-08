package org.txazo.reflection.type;

import org.txazo.test.SuiteTest;
import org.txazo.test.annotation.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.List;
import java.util.Map;

/**
 * WildcardType - 通配符泛型
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.lang.reflect.WildcardType
 * @since 01.06.2015
 */
public class WildcardTypeTest extends SuiteTest {

    private class MyClass {

        private List<? extends Map> list;

    }

    @Test
    public void test1() throws NoSuchFieldException {
        Type type = MyClass.class.getDeclaredField("list").getGenericType();
        type = ((ParameterizedType) type).getActualTypeArguments()[0];
        assertTrue(type instanceof WildcardType);
        WildcardType wType = (WildcardType) type;
        assertSame(Map.class, wType.getUpperBounds()[0]);
    }

}
