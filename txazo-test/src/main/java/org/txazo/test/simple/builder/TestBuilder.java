package org.txazo.test.simple.builder;

import org.txazo.test.simple.Ignore;
import org.txazo.test.simple.Test;
import org.txazo.test.simple.test.ClassTest;
import org.txazo.test.simple.test.MethodTest;
import org.txazo.test.simple.test.SuiteTest;
import org.txazo.test.util.AssertUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * TestBuilder
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public class TestBuilder {

    public static MethodTest buildMethodTest(Method method) {
        return new MethodTest(method);
    }

    public static Map<Method, MethodTest> buildMethodTests(Class<?> clazz) {
        AssertUtils.assertNotNull(clazz);
        Map<Method, MethodTest> methodTests = new HashMap<Method, MethodTest>();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getAnnotation(Test.class) != null && method.getAnnotation(Ignore.class) == null) {
                methodTests.put(method, buildMethodTest(method));
            }
        }
        return methodTests;
    }

    public static ClassTest buildClassTest(Class<?> clazz) {
        return buildClassTest(clazz, true);
    }

    public static ClassTest buildClassTest(Class<?> clazz, boolean init) {
        AssertUtils.assertNotNull(clazz);
        return new ClassTest(clazz, init);
    }

    public static Map<Class<?>, ClassTest> buildClassTests(Set<Class<?>> classes) {
        AssertUtils.assertNotNull(classes);
        Map<Class<?>, ClassTest> classTests = new HashMap<Class<?>, ClassTest>();
        for (Class<?> clazz : classes) {
            classTests.put(clazz, buildClassTest(clazz));
        }
        return classTests;
    }

    public static SuiteTest buildSuiteTest(Set<Class<?>> classes) {
        AssertUtils.assertNotNull(classes);
        return new SuiteTest(classes);
    }

    public static SuiteTest buildSuiteTest(MethodTest methodTest) {
        ClassTest classTest = new ClassTest();
        classTest.addMethodTest(methodTest);
        return buildSuiteTest(classTest);
    }

    public static SuiteTest buildSuiteTest(ClassTest classTest) {
        SuiteTest suiteTest = new SuiteTest();
        suiteTest.addClassTest(classTest);
        return suiteTest;
    }

}
