package org.txazo.reflection;

import org.txazo.test.runner.SuiteTestRunner;
import org.txazo.test.runner.TestRunner;

/**
 * RunnerTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 26.05.2015
 */
public class RunnerTest {

    public static void main(String[] args) throws ClassNotFoundException {
        TestRunner runner = new SuiteTestRunner();
        runner.run("org.txazo.reflection", true);
    }

}
