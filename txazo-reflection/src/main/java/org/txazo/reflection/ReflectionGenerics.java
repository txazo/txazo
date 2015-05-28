package org.txazo.reflection;

import org.apache.commons.lang3.ArrayUtils;
import org.txazo.test.SuiteTest;
import org.txazo.test.annotation.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * ReflectionGenerics
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 28.05.2015
 */
public class ReflectionGenerics extends SuiteTest {

    private class MapClass {

        private Map<String, Integer> map;

        public Map<String, Integer> getMap() {
            return map;
        }

        public void setMap(Map<String, Integer> map, List<String> list) {
            this.map = map;
        }

    }

    private Class<?>[] getGenericTypeClass(Type type) {
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypes = parameterizedType.getActualTypeArguments();
            if (ArrayUtils.isNotEmpty(actualTypes)) {
                Class<?>[] classes = new Class<?>[actualTypes.length];
                for (int i = 0; i < actualTypes.length; i++) {
                    classes[i] = (Class<?>) actualTypes[i];
                }
                return classes;
            }
        }
        return ArrayUtils.EMPTY_CLASS_ARRAY;
    }

    @Test
    public void test1() throws NoSuchFieldException {
        /** 范型变量类型 */
        Type fieldGenericType = MapClass.class.getDeclaredField("map").getGenericType();
        assertTrue(Arrays.equals(getGenericTypeClass(fieldGenericType), new Class<?>[]{String.class, Integer.class}));
    }

    @Test
    public void test2() throws NoSuchFieldException, NoSuchMethodException {
        /** 范型方法返回类型 */
        Type genericReturnType = MapClass.class.getMethod("getMap", null).getGenericReturnType();
        assertTrue(Arrays.equals(getGenericTypeClass(genericReturnType), new Class<?>[]{String.class, Integer.class}));
    }

    @Test
    public void test3() throws NoSuchMethodException {
        /** 范型方法参数类型 */
        Type[] genericParameterTypes = MapClass.class.getMethod("setMap", Map.class, List.class).getGenericParameterTypes();
        assertTrue(Arrays.equals(getGenericTypeClass(genericParameterTypes[0]), new Class<?>[]{String.class, Integer.class}));
        assertTrue(Arrays.equals(getGenericTypeClass(genericParameterTypes[1]), new Class<?>[]{String.class}));
    }

}
