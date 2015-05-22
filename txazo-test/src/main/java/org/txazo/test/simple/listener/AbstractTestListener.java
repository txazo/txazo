package org.txazo.test.simple.listener;

import java.io.PrintStream;

/**
 * AbstractTestListener
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public abstract class AbstractTestListener implements TestListener {

    protected PrintStream writer;

    public AbstractTestListener(PrintStream writer) {
        this.writer = writer;
    }

    public PrintStream getWriter() {
        return writer;
    }

}
