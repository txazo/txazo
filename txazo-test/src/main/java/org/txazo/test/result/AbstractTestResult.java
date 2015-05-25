package org.txazo.test.result;

import org.txazo.test.listener.TestListener;

import java.io.PrintStream;

/**
 * AbstractTestResult
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.05.2015
 */
public abstract class AbstractTestResult implements TestResult {

    protected PrintStream writer;
    protected TestListener listener;

    public AbstractTestResult(PrintStream writer, TestListener listener) {
        this.writer = writer;
        this.listener = listener;
    }

}
