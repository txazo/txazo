package org.txazo.test.simple.runner;

import org.txazo.test.simple.suite.TestSuite;
import org.txazo.test.util.AssertUtils;

import java.lang.reflect.Method;
import java.util.List;

/**
 * SimpleTestRunner
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public class SimpleTestRunner implements TestRunner {

    @Override
    public TestResult run(String className) {
        AssertUtils.assertNotBlank(className);
        Class<?> clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return run(clazz);
    }

    @Override
    public TestResult run(String packageName, boolean recursive) {
        return null;
    }

    @Override
    public TestResult run(Class<?> clazz) {
        AssertUtils.assertNotNull(clazz);
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            run(clazz, method);
        }
        return null;
    }

    @Override
    public TestResult run(Class<?> clazz, Method method) {
        AssertUtils.assertNotNull(clazz, method);
        return null;
    }

    @Override
    public TestResult run(Class<?> clazz, String methodName, Class<?>[] paramTypes) {
        AssertUtils.assertNotNull(clazz);
        AssertUtils.assertNotBlank(methodName);
        Method method = null;
        try {
            method = clazz.getMethod(methodName, paramTypes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return run(clazz, method);
    }

    @Override
    public TestResult run(List<Class<?>> classes) {
        return null;
    }

    @Override
    public TestResult run(TestSuite suite) {
        return null;
    }

}
