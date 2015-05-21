package org.txazo.test.simple.test;

import org.txazo.test.simple.builder.TestBuilder;
import org.txazo.test.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * SuiteTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public class SuiteTest extends AbstractTest {

    private Set<Class<?>> classes;
    private Set<ClassTest> classTests = new HashSet<ClassTest>();

    public SuiteTest() {
    }

    public SuiteTest(Set<Class<?>> classes) {
        this.classes = classes;
        this.classTests = TestBuilder.buildClassTests(classes);
    }

    @Override
    public void test() {

    }

    public void addClassTest(ClassTest classTest) {
        classTests.add(classTest);
    }

    public void addSuiteTest(String className) {
        this.addSuiteTest(ReflectionUtils.getClass(className));
    }

    public void addSuiteTest(String packageName, boolean recursive) {
    }

    public void addSuiteTest(Class<?> clazz) {
        classTests.add(TestBuilder.buildClassTest(clazz));
    }

    public void addSuiteTest(Class<?> clazz, Method method) {
    }

    public void addSuiteTest(Class<?> clazz, String method, Class<?>[] paramTypes) {
    }

    public void addSuiteTest(Set<Class<?>> classes) {
        Set<ClassTest> classTests = TestBuilder.buildClassTests(classes);
        this.classTests.addAll(classTests);
    }

}
