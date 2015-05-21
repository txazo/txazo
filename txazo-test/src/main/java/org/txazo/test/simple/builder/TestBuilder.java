package org.txazo.test.simple.builder;

import org.txazo.test.simple.Test;
import org.txazo.test.simple.test.ClassTest;
import org.txazo.test.simple.test.MethodTest;
import org.txazo.test.simple.test.SuiteTest;
import org.txazo.test.util.AssertUtils;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * TestBuilder
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public class TestBuilder {

    public static MethodTest buildMethodTest(Class<?> clazz, Method method) {
        AssertUtils.assertNotNull(clazz, method);
        return new MethodTest(clazz, method);
    }

    public static Set<MethodTest> buildMethodTests(Class<?> clazz) {
        AssertUtils.assertNotNull(clazz);
        Set<MethodTest> methodTests = new HashSet<MethodTest>();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.getAnnotation(Test.class) != null) {
                methodTests.add(buildMethodTest(clazz, method));
            }
        }
        return methodTests;
    }

    public static ClassTest buildClassTest(Class<?> clazz) {
        AssertUtils.assertNotNull(clazz);
        return new ClassTest(clazz);
    }

    public static Set<ClassTest> buildClassTests(Set<Class<?>> classes) {
        AssertUtils.assertNotNull(classes);
        Set<ClassTest> classTests = new HashSet<ClassTest>();
        for (Class<?> clazz : classes) {
            classTests.add(buildClassTest(clazz));
        }
        return classTests;
    }

    public static SuiteTest buildSuiteTest(Set<Class<?>> classes) {
        AssertUtils.assertNotNull(classes);
        return new SuiteTest(classes);
    }

    public static SuiteTest wrapSuiteTest(MethodTest methodTest) {
        ClassTest classTest = new ClassTest();
        classTest.addMethodTest(methodTest);
        return wrapSuiteTest(classTest);
    }

    public static SuiteTest wrapSuiteTest(ClassTest classTest) {
        SuiteTest suiteTest = new SuiteTest();
        suiteTest.addClassTest(classTest);
        return suiteTest;
    }

}
