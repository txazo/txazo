package org.txazo.test.simple.register;

import org.txazo.test.simple.listener.ClassTestListener;
import org.txazo.test.simple.listener.MethodTestListener;
import org.txazo.test.simple.listener.SuiteTestListener;
import org.txazo.test.simple.listener.TestListener;
import org.txazo.test.simple.test.AbstractTest;
import org.txazo.test.simple.test.ClassTest;
import org.txazo.test.simple.test.MethodTest;
import org.txazo.test.simple.test.SuiteTest;

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

    private static final Map<Class<? extends AbstractTest>, Class<? extends TestListener>> listenerRegistery = new HashMap<Class<? extends AbstractTest>, Class<? extends TestListener>>();

    static {
        registerListener(MethodTest.class, MethodTestListener.class);
        registerListener(ClassTest.class, ClassTestListener.class);
        registerListener(SuiteTest.class, SuiteTestListener.class);
    }

    public static void registerListener(Class<? extends AbstractTest> testClass, Class<? extends TestListener> listenerClass) {
        listenerRegistery.put(testClass, listenerClass);
    }

}
