package org.txazo.test.simple.test;

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

    private static TestExecuor execuor = new TestExecuor();

    public MethodTest(Class<?> clazz, Method method) {
        this.clazz = clazz;
        this.method = method;
    }

    @Override
    public void test() {
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public Method getMethod() {
        return method;
    }

}
