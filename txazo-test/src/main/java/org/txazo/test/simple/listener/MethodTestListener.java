package org.txazo.test.simple.listener;

import java.io.PrintStream;

/**
 * MethodTestListener
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public class MethodTestListener extends AbstractTestListener {

    public MethodTestListener(PrintStream writer) {
        super(writer);
    }

    @Override
    public void testBefore() {
        writer.println("method testBefore");
    }

    @Override
    public void testAfter() {
        writer.println("method testAfter");
    }

}
