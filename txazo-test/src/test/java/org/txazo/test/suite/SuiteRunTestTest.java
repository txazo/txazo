package org.txazo.test.suite;

import org.txazo.test.exception.TestException;

/**
 * SuiteRunTestTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 17.05.2015
 */
public class SuiteRunTestTest {

    public static void main(String[] args) throws TestException {
        new SuiteRunTest("org.txazo.test").run();
    }

}
