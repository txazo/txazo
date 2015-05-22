package org.txazo.test.util;

import org.txazo.test.exception.TestException;

import java.lang.reflect.Method;

/**
 * ReflectionUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public abstract class ReflectionUtils {

    public static Class<?> getClass(String className) {
        AssertUtils.assertNotBlank(className);
        Class<?> clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new TestException(e);
        }
        return clazz;
    }

    public static Method getMethod(Class<?> clazz, String methodName, Class<?>[] paramTypes) {
        AssertUtils.assertNotNull(clazz, paramTypes);
        AssertUtils.assertNotBlank(methodName);
        Method method = null;
        try {
            method = clazz.getMethod(methodName, paramTypes);
        } catch (NoSuchMethodException e) {
            throw new TestException(e);
        }
        return method;
    }

}
