package org.txazo.test;

import org.txazo.test.assertion.Assert;

/**
 * AbstractTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.05.2015
 */
public abstract class AbstractTest extends Assert {

    protected static void print(Object msg) {
        System.out.println("[INFO] " + msg);
    }

    protected static void println(Object msg) {
        System.out.println("[INFO] " + msg);
    }

}
