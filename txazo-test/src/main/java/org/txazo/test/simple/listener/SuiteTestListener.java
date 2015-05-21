package org.txazo.test.simple.listener;

import java.io.PrintStream;

/**
 * SuiteTestListener
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public class SuiteTestListener extends AbstractTestListener {

    public SuiteTestListener(PrintStream writer) {
        super(writer);
    }

    @Override
    public void testBefore() {
        writer.println("suite testBefore");
    }

    @Override
    public void testAfter() {
        writer.println("suite testAfter");
    }

}
