package org.txazo.test.simple.test;

import org.txazo.test.simple.After;
import org.txazo.test.simple.Before;
import org.txazo.test.simple.runner.TestExecuor;

import java.lang.reflect.Method;

/**
 * MethodTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public class MethodTest extends AbstractTest {

    private Class<?> clazz;
    private Method method;

    public MethodTest(Method method) {
        this.clazz = method.getDeclaringClass();
        this.method = method;
    }

    @Override
    public void test() {
        TestExecuor.executeAnnotationMethods(clazz, Before.class, false);
        TestExecuor.executeNoneStaticMethod(method);
        TestExecuor.executeAnnotationMethods(clazz, After.class, false);
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public Method getMethod() {
        return method;
    }

}
