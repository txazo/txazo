package org.txazo.test.simple.runner;

import org.apache.commons.lang3.ArrayUtils;
import org.txazo.test.exception.TestException;
import org.txazo.test.util.AssertUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TestExecuor
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.05.2015
 */
public abstract class TestExecuor {

    private static ReentrantLock lock = new ReentrantLock();
    private static Map<Class<?>, Object> instances = new HashMap<Class<?>, Object>();

    protected static <T> T getInstance(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        AssertUtils.assertNotNull(clazz);
        if (instances.containsKey(clazz)) {
            return (T) instances.get(clazz);
        }

        lock.lock();
        T instance = null;
        try {
            if (instances.containsKey(clazz)) {
                return (T) instances.get(clazz);
            }
            instance = clazz.newInstance();
            instances.put(clazz, instance);
        } finally {
            lock.unlock();
        }

        return instance;
    }

    public static void executeStaticMethod(Method method) {
        AssertUtils.assertNotNull(method);
        if (!Modifier.isStatic(method.getModifiers())) {
            throw new TestException("method " + method.getName() + "() must be static");
        }
        if (ArrayUtils.isNotEmpty(method.getParameterTypes())) {
            throw new TestException("method " + method.getName() + "() must has no parameters");
        }
        try {
            method.invoke(null, null);
        } catch (Throwable t) {
            throw new TestException(t);
        }
    }

    public static void executeNoneStaticMethod(Method method) {
        AssertUtils.assertNotNull(method);
        if (Modifier.isStatic(method.getModifiers())) {
            throw new TestException("method " + method.getName() + "() must be not static");
        }
        if (ArrayUtils.isNotEmpty(method.getParameterTypes())) {
            throw new TestException("method " + method.getName() + "() must has no parameters");
        }
        try {
            method.invoke(getInstance(method.getDeclaringClass()), null);
        } catch (Throwable t) {
            throw new TestException(t);
        }
    }

    public static void executeAnnotationMethods(Class<?> clazz, Class<? extends Annotation> annotationClass, boolean isStatic) {
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getAnnotation(annotationClass) != null) {
                if (isStatic) {
                    executeStaticMethod(method);
                } else {
                    executeNoneStaticMethod(method);
                }
            }
        }
    }

}
