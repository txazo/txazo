package org.txazo.test.simple.listener;

import java.io.PrintStream;

/**
 * ClassTestListener
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public class ClassTestListener extends AbstractTestListener {

    public ClassTestListener(PrintStream writer) {
        super(writer);
    }

    @Override
    public void testBefore() {
        writer.println("class testBefore");
    }

    @Override
    public void testAfter() {
        writer.println("class testAfter");
    }

}
