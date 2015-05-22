package org.txazo.test.simple.register;

import org.txazo.test.simple.builder.BuildFactory;
import org.txazo.test.simple.listener.*;
import org.txazo.test.simple.test.AbstractTest;
import org.txazo.test.simple.test.ClassTest;
import org.txazo.test.simple.test.MethodTest;
import org.txazo.test.simple.test.SuiteTest;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Registery
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public abstract class Registery {

    private static final Map<Class<? extends AbstractTest>, Class<? extends AbstractTestListener>> listenerRegistery = new HashMap<Class<? extends AbstractTest>, Class<? extends AbstractTestListener>>();

    static {
        registerListener(MethodTest.class, MethodTestListener.class);
        registerListener(ClassTest.class, ClassTestListener.class);
        registerListener(SuiteTest.class, SuiteTestListener.class);
    }

    public static void registerListener(Class<? extends AbstractTest> testClass, Class<? extends AbstractTestListener> listenerClass) {
        listenerRegistery.put(testClass, listenerClass);
    }

    public static AbstractTestListener getRegisterTestListener(Class<? extends AbstractTest> testClass, PrintStream writer) {
        return BuildFactory.buildTestListener(listenerRegistery.get(testClass), writer);
    }

}
