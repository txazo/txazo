package org.txazo.test.simple.runner;

import org.txazo.test.simple.suite.Suite;
import org.txazo.test.simple.test.ClassTest;
import org.txazo.test.simple.test.MethodTest;
import org.txazo.test.simple.test.SuiteTest;
import org.txazo.test.simple.builder.TestBuilder;
import org.txazo.test.util.AssertUtils;
import org.txazo.test.util.PackageUtils;
import org.txazo.test.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * SimpleTestRunner
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public class SimpleTestRunner implements TestRunner {

    @Override
    public void run(String className) {
        this.run(ReflectionUtils.getClass(className));
    }

    @Override
    public void run(String packageName, boolean recursive) {
        this.run(PackageUtils.getClassesWithAnnotation(packageName, Suite.class, recursive));
    }

    @Override
    public void run(Class<?> clazz) {
        this.run(TestBuilder.buildSuiteTest(TestBuilder.buildClassTest(clazz)));
    }

    @Override
    public void run(Class<?> clazz, Method method) {
        this.run(TestBuilder.buildSuiteTest(TestBuilder.buildMethodTest(clazz, method)));
    }

    @Override
    public void run(Class<?> clazz, String methodName, Class<?>[] paramTypes) {
        this.run(clazz, ReflectionUtils.getMethod(clazz, methodName, paramTypes));
    }

    @Override
    public void run(Set<Class<?>> classes) {
        this.run(TestBuilder.buildSuiteTest(classes));
    }

    private void run(MethodTest methodTest) {
        this.run(TestBuilder.buildSuiteTest(methodTest));
    }

    private void run(ClassTest classTest) {
        this.run(TestBuilder.buildSuiteTest(classTest));
    }

    @Override
    public void run(SuiteTest suiteTest) {
        AssertUtils.assertNotNull(suiteTest);
    }

}
