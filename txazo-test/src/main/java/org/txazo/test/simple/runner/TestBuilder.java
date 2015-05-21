package org.txazo.test.simple.runner;

import org.txazo.test.simple.test.ClassTest;
import org.txazo.test.simple.test.MethodTest;
import org.txazo.test.simple.test.SuiteTest;

import java.lang.reflect.Method;
import java.util.List;

/**
 * TestBuilder
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public class TestBuilder {

    public MethodTest buildMethodTest(Class<?> clazz, Method method) {
        return new MethodTest(clazz, method);
    }

    public ClassTest buildClassTest(Class<?> clazz) {
        return new ClassTest(clazz);
    }

    public SuiteTest buildSuiteTest(List<Class<?>> classes) {
        return new SuiteTest(classes);
    }

}
