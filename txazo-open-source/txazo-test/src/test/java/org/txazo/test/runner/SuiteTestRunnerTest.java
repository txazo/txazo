package org.txazo.test.runner;

/**
 * SuiteTestRunnerTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.05.2015
 */
public class SuiteTestRunnerTest {

    public static void main(String[] args) {
        TestRunner runner = new SuiteTestRunner();
        runner.run("org.txazo.test", true);
    }

}
