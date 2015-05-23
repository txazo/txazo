package org.txazo.test.simple.result;

import org.txazo.test.simple.assertion.AssertionFailedError;
import org.txazo.test.simple.test.AbstractTest;

/**
 * TestFailure
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.05.2015
 */
public class TestFailure {

    private AbstractTest test;
    private Throwable throwable;

    public TestFailure(AbstractTest test, Throwable throwable) {
        this.test = test;
        this.throwable = throwable;
    }

    public AbstractTest getTest() {
        return test;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public boolean isFailure() {
        return throwable instanceof AssertionFailedError;
    }

}
