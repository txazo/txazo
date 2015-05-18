package org.txazo.test.suite;

import junit.framework.*;
import junit.framework.Test;
import junit.textui.ResultPrinter;
import org.junit.runner.Description;

import java.io.PrintStream;
import java.util.Enumeration;
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
        super.getWriter().println("Time: " + this.elapsedTimeAsString(runTime) + "s");
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
    protected void printDefects(Enumeration<TestFailure> booBoos, int count, String type) {
        super.printDefects(booBoos, count, type);
    }

    @Override
    public void printDefect(TestFailure booBoo, int count) {
        super.printDefect(booBoo, count);
    }

    @Override
    protected void printDefectHeader(TestFailure booBoo, int count) {
        super.printDefectHeader(booBoo, count);
    }

    @Override
    protected void printDefectTrace(TestFailure booBoo) {
        super.printDefectTrace(booBoo);
    }

    @Override
    protected void printFooter(TestResult result) {
        super.printFooter(result);
    }

    @Override
    protected String elapsedTimeAsString(long runTime) {
        return super.elapsedTimeAsString(runTime);
    }

    @Override
    public void addError(Test test, Throwable e) {
        super.addError(test, e);
    }

    @Override
    public void addFailure(Test test, AssertionFailedError t) {
        super.addFailure(test, t);
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

}
