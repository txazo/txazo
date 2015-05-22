package org.txazo.test.simple.test;

import org.txazo.test.simple.listener.AbstractTestListener;

/**
 * AbstractTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public abstract class AbstractTest {

    protected AbstractTestListener listener;

    public final void runTest() {
        listener.testBefore();
        test();
        listener.testAfter();
    }

    public abstract void test();

    public void registerListener(AbstractTestListener listener) {
        this.listener = listener;
    }

}
