package org.txazo.test.simple.runner;

import org.txazo.test.simple.suite.TestSuite;

import java.lang.reflect.Method;
import java.util.List;

/**
 * TestRunner
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public interface TestRunner {

    public TestResult run(String className);

    public TestResult run(String packageName, boolean recursive);

    public TestResult run(Class<?> clazz);

    public TestResult run(Class<?> clazz, Method method);

    public TestResult run(Class<?> clazz, String method, Class<?>[] params);

    public TestResult run(List<Class<?>> classes);

    public TestResult run(TestSuite suite);

}
