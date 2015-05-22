package org.txazo.test.simple.test;

import org.txazo.test.simple.AfterClass;
import org.txazo.test.simple.BeforeClass;
import org.txazo.test.simple.builder.TestBuilder;
import org.txazo.test.simple.listener.TestListener;
import org.txazo.test.simple.runner.TestExecuor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * ClassTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public class ClassTest extends AbstractTest {

    private Class<?> clazz;
    private Map<Method, MethodTest> methodTests = new HashMap<Method, MethodTest>();

    public ClassTest() {
    }

    public ClassTest(Class<?> clazz, boolean init) {
        this.clazz = clazz;
        if (init) {
            this.methodTests = TestBuilder.buildMethodTests(clazz);
        }
    }

    @Override
    public void test() {
        TestExecuor.executeAnnotationMethods(clazz, BeforeClass.class, true);
        for (Iterator<Map.Entry<Method, MethodTest>> i = methodTests.entrySet().iterator(); i.hasNext(); ) {
            i.next().getValue().runTest();
        }
        TestExecuor.executeAnnotationMethods(clazz, AfterClass.class, true);
    }

    @Override
    public void registerListener(TestListener listener) {
        super.registerListener(listener);
        for (Iterator<Map.Entry<Method, MethodTest>> i = methodTests.entrySet().iterator(); i.hasNext(); ) {
            i.next().getValue().registerListener(listener);
        }
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public synchronized void addMethodTest(MethodTest methodTest) {
        if (clazz == null) {
            clazz = methodTest.getClazz();
        }
        if (!methodTests.containsKey(methodTest.getMethod())) {
            methodTests.put(methodTest.getMethod(), methodTest);
        }
    }

}
