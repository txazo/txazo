package org.txazo.test.simple.runner;

import org.txazo.test.simple.test.SuiteTest;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * TestRunner
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public interface TestRunner {

    public void run(String className);

    public void run(String packageName, boolean recursive);

    public void run(Class<?> clazz);

    public void run(Class<?> clazz, Method method);

    public void run(Class<?> clazz, String method, Class<?>[] paramTypes);

    public void run(Set<Class<?>> classes);

    public void run(SuiteTest suiteTest);

}
