package org.txazo.test.runner;

import org.txazo.test.annotation.Test;
import org.txazo.test.assertion.AssertionFailedError;
import org.txazo.test.exception.TestException;
import org.txazo.test.util.ArrayUtils;
import org.txazo.test.util.AssertUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
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

    public static Object executeStaticMethod(Method method) {
        AssertUtils.assertNotNull(method);
        if (!Modifier.isStatic(method.getModifiers())) {
            throw new TestException("method " + method.getName() + "() must be static");
        }
        if (ArrayUtils.isNotEmpty(method.getParameterTypes())) {
            throw new TestException("method " + method.getName() + "() must has no parameters");
        }
        try {
            return method.invoke(null, null);
        } catch (Throwable t) {
            throw new TestException(t);
        }
    }

    public static Object executeNoneStaticMethod(Method method) {
        AssertUtils.assertNotNull(method);
        if (Modifier.isStatic(method.getModifiers())) {
            throw new TestException("method " + method.getName() + "() must be not static");
        }
        if (ArrayUtils.isNotEmpty(method.getParameterTypes())) {
            throw new TestException("method " + method.getName() + "() must has no parameters");
        }
        try {
            return method.invoke(getInstance(method.getDeclaringClass()), null);
        } catch (Throwable t) {
            throw new TestException(t);
        }
    }

    public static Object executeNoneStaticMethod(final Method method, Class<? extends Throwable> clazz, long timeout) {
        boolean throwed = false;
        try {
            if (timeout <= 0) {
                return executeNoneStaticMethod(method);
            } else {
                FutureTask task = new FutureTask(new Callable() {

                    @Override
                    public Object call() throws Exception {
                        return executeNoneStaticMethod(method);
                    }

                });

                Thread thread = new Thread(task);
                thread.setDaemon(true);
                thread.start();

                try {
                    return task.get(timeout, TimeUnit.MILLISECONDS);
                } catch (Throwable t) {
                    if (t instanceof TimeoutException) {
                        t = new AssertionFailedError(t);
                    }
                    throw new TestException(t);
                }
            }
        } catch (TestException e) {
            throwed = true;
            if (!(e.getCause() instanceof InvocationTargetException)) {
                throw e;
            }
            if (!(((InvocationTargetException) e.getCause()).getTargetException().getClass() == clazz)) {
                throw new TestException(new AssertionFailedError("expected and actual Throwable must be same"));
            }
        } finally {
            if (!throwed && clazz != Test.None.class) {
                throw new TestException(new AssertionFailedError("expected Throwable is null"));
            }
        }
        return null;
    }

    public static Object executeAnnotationMethods(Class<?> clazz, Class<? extends Annotation> annotationClass, boolean isStatic) {
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getAnnotation(annotationClass) != null) {
                if (isStatic) {
                    return executeStaticMethod(method);
                } else {
                    return executeNoneStaticMethod(method);
                }
            }
        }
        return null;
    }

}
