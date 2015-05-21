package org.txazo.test.simple.test;

import org.txazo.test.simple.builder.TestBuilder;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public class ClassTest extends AbstractTest {

    private Class<?> clazz;
    private Set<MethodTest> methodTests = new HashSet<MethodTest>();

    public ClassTest() {
    }

    public ClassTest(Class<?> clazz) {
        this.clazz = clazz;
        this.methodTests = TestBuilder.buildMethodTests(clazz);
    }

    @Override
    public void test() {

    }

    public void addMethodTest(MethodTest methodTest) {
        methodTests.add(methodTest);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassTest classTest = (ClassTest) o;
        return !(clazz != null ? !clazz.equals(classTest.clazz) : classTest.clazz != null);

    }

    @Override
    public int hashCode() {
        return clazz != null ? clazz.hashCode() : 0;
    }
}
