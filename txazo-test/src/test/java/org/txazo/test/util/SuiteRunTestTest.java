package org.txazo.test.util;

import org.txazo.test.SuiteRunTest;
import org.txazo.test.exception.TxazoTestException;

/**
 * SuiteRunTestTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 17.05.2015
 */
public class SuiteRunTestTest {

    public static void main(String[] args) throws TxazoTestException {
        new SuiteRunTest("org.txazo.test").run();
    }

}
