package org.txazo.classfile.analysis.util;

import java.lang.reflect.Field;

public class ReflectionUtils {

    public static <T> T getFieldValue(Object obj, String fieldName, Class<T> returnClass) throws Exception {
        Class<?> clazz = obj.getClass();
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        return (T) field.get(obj);
    }

}
