package org.txazo.test.test;

import org.txazo.test.exception.TestException;
import org.txazo.test.listener.TestListener;

import java.lang.reflect.InvocationTargetException;

/**
 * AbstractTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public abstract class AbstractTest {

    protected TestListener listener;

    public final void runTest(TestListener listener) {
        this.listener = listener;

        this.listener.testBefore(this);
        test();
        this.listener.testAfter(this);
    }

    public abstract void test();

    public Throwable getCauseThrowable(TestException exception) {
        if (exception.getCause() instanceof InvocationTargetException) {
            InvocationTargetException target = (InvocationTargetException) exception.getCause();
            return target.getTargetException();
        }
        return exception;
    }

}
