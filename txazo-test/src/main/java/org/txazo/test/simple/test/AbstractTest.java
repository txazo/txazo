package org.txazo.test.simple.test;

import org.txazo.test.simple.listener.TestListener;

/**
 * AbstractTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public abstract class AbstractTest {

    protected TestListener listener;

    public void runTest() {
        listener.testBefore();
        this.test();
        listener.testAfter();
    }

    public abstract void test();

    public void setListener(TestListener listener) {
        this.listener = listener;
    }

}
