package org.txazo.test.runner;

import org.txazo.test.annotation.Suite;
import org.txazo.test.result.TestResult;
import org.txazo.test.test.ClassTest;
import org.txazo.test.test.MethodTest;
import org.txazo.test.test.SuiteTest;
import org.txazo.test.builder.TestBuilder;
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
    public void run(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        run(ReflectionUtils.getMethod(clazz, methodName, parameterTypes));
    }

    @Override
    public void run(Method method) {
        run(TestBuilder.buildSuiteTest(TestBuilder.buildMethodTest(method)));
    }

    @Override
    public void run(String className) {
        run(ReflectionUtils.getClass(className));
    }

    @Override
    public void run(Class<?> clazz) {
        run(TestBuilder.buildSuiteTest(TestBuilder.buildClassTest(clazz)));
    }

    @Override
    public void run(String packageName, boolean recursive) {
        run(PackageUtils.getClassesWithAnnotation(packageName, Suite.class, recursive));
    }

    @Override
    public void run(Set<Class<?>> classes) {
        run(TestBuilder.buildSuiteTest(classes));
    }

    private void run(MethodTest methodTest) {
        run(TestBuilder.buildSuiteTest(methodTest));
    }

    private void run(ClassTest classTest) {
        run(TestBuilder.buildSuiteTest(classTest));
    }

    @Override
    public void run(SuiteTest suiteTest) {
        AssertUtils.assertNotNull(suiteTest);
        TestResult result = suiteTest.run(System.err);
        result.printResult();
    }

}
