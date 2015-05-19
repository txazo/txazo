package org.txazo.test.suite;

import junit.framework.*;
import junit.framework.Test;
import junit.textui.ResultPrinter;
import org.junit.runner.Description;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/**
 * SuiteResultPrinter
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 18.05.2015
 */
public class SuiteResultPrinter extends ResultPrinter {

    private Map<String, Long> runTimes = new HashMap<String, Long>();

    public SuiteResultPrinter(PrintStream writer) {
        super(writer);
    }

    synchronized void print(TestResult result, long runTime) {
        this.printHeader(runTime);
        this.printErrors(result);
        this.printFailures(result);
        this.printFooter(result);
    }

    @Override
    protected void printHeader(long runTime) {
        this.println("Time: " + super.elapsedTimeAsString(runTime) + "s");
    }

    @Override
    protected void printErrors(TestResult result) {
        super.printErrors(result);
    }

    @Override
    protected void printFailures(TestResult result) {
        super.printFailures(result);
    }

    @Override
    protected void printFooter(TestResult result) {
        if (result.wasSuccessful()) {
            this.print("OK");
            this.println(" (" + result.runCount() + " test" + (result.runCount() == 1 ? "" : "s") + ")");
        } else {
            this.println("FAILURES!!!");
            this.println("Tests run: " + result.runCount() + ",  Failures: " + result.failureCount() + ",  Errors: " + result.errorCount());
        }
    }

    @Override
    public void addError(Test test, Throwable e) {
        e.printStackTrace(super.getWriter());
    }

    @Override
    public void addFailure(Test test, AssertionFailedError t) {
        t.printStackTrace(super.getWriter());
    }

    @Override
    public void endTest(Test test) {
        String testName = getTestName(test);
        long startTime = runTimes.get(testName);
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        this.printHeader(runTime);
        super.getWriter().println("-------------------------------------------------------");
    }

    @Override
    public void startTest(Test test) {
        String testName = getTestName(test);
        super.getWriter().println("Running " + testName);
        runTimes.put(testName, System.currentTimeMillis());
    }

    protected String getTestName(Test test) {
        JUnit4TestCaseFacade testCaseFacade = (JUnit4TestCaseFacade) test;
        Description desp = testCaseFacade.getDescription();
        return desp.getTestClass().getName() + "." + desp.getMethodName() + "()";
    }

    protected void print(Object msg) {
        super.getWriter().print(msg);
    }

    protected void println(Object msg) {
        super.getWriter().println(msg);
    }

}
