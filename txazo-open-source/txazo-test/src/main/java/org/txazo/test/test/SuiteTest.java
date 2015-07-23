package org.txazo.test.test;

import org.txazo.test.annotation.Suite;
import org.txazo.test.builder.TestBuilder;
import org.txazo.test.listener.SuiteTestListener;
import org.txazo.test.result.SuiteTestResult;
import org.txazo.test.result.TestResult;
import org.txazo.test.util.PackageUtils;
import org.txazo.test.util.ReflectionUtils;

import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * SuiteTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public class SuiteTest extends AbstractTest {

    private Map<Class<?>, ClassTest> classTests = new HashMap<Class<?>, ClassTest>();

    public SuiteTest() {
    }

    public SuiteTest(Set<Class<?>> classes) {
        this.classTests = TestBuilder.buildClassTests(classes);
    }

    @Override
    public void test() {
        for (Iterator<Map.Entry<Class<?>, ClassTest>> i = classTests.entrySet().iterator(); i.hasNext(); ) {
            i.next().getValue().runTest(listener);
        }
    }

    public TestResult run(PrintStream writer) {
        listener = new SuiteTestListener(writer);
        runTest(listener);
        return new SuiteTestResult(writer, listener);
    }

    public synchronized void addClassTest(ClassTest classTest) {
        if (!classTests.containsKey(classTest.getClazz())) {
            classTests.put(classTest.getClazz(), classTest);
        }
    }

    public synchronized void addMethodTest(MethodTest methodTest) {
        if (classTests.containsKey(methodTest.getClazz())) {
            classTests.get(methodTest.getClazz()).addMethodTest(methodTest);
        } else {
            ClassTest classTest = TestBuilder.buildClassTest(methodTest.getClazz(), false);
            classTest.addMethodTest(methodTest);
            addClassTest(classTest);
        }
    }

    public void addSuiteTest(String className) {
        addSuiteTest(ReflectionUtils.getClass(className));
    }

    public void addSuiteTest(String packageName, boolean recursive) {
        addSuiteTest(PackageUtils.getClassesWithAnnotation(packageName, Suite.class, org.txazo.test.SuiteTest.class, recursive));
    }

    public void addSuiteTest(Class<?> clazz) {
        addClassTest(TestBuilder.buildClassTest(clazz));
    }

    public void addSuiteTest(Class<?> clazz, Method method) {
        addMethodTest(TestBuilder.buildMethodTest(method));
    }

    public void addSuiteTest(Class<?> clazz, String method, Class<?>[] paramTypes) {
        addSuiteTest(clazz, ReflectionUtils.getMethod(clazz, method, paramTypes));
    }

    public synchronized void addSuiteTest(Set<Class<?>> classes) {
        Map<Class<?>, ClassTest> classTests = TestBuilder.buildClassTests(classes);
        this.classTests.putAll(classTests);
    }

}
