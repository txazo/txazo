package org.txazo.test.builder;

import org.txazo.test.exception.TestException;
import org.txazo.test.listener.AbstractTestListener;

import java.io.PrintStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * BuildFactory
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.05.2015
 */
public abstract class BuildFactory {

    private static Map<Class<? extends AbstractTestListener>, AbstractTestListener> listeners = new HashMap<Class<? extends AbstractTestListener>, AbstractTestListener>();

    public static AbstractTestListener buildTestListener(Class<? extends AbstractTestListener> listenerClass, PrintStream writer) {
        if (listeners.containsKey(listenerClass)) {
            return listeners.get(listenerClass);
        }
        AbstractTestListener listener = null;
        try {
            Constructor<?> constructor = listenerClass.getConstructor(PrintStream.class);
            listener = (AbstractTestListener) constructor.newInstance(writer);
        } catch (Exception e) {
            throw new TestException(e);
        }
        listeners.put(listenerClass, listener);
        return listener;
    }

}
