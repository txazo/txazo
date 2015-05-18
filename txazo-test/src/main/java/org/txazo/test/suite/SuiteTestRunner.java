package org.txazo.test.suite;

import junit.framework.Test;
import junit.framework.TestResult;
import junit.textui.TestRunner;

import java.io.PrintStream;

/**
 * SuiteTestRunner
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 17.05.2015
 */
public class SuiteTestRunner extends TestRunner {

    private SuiteResultPrinter printer;

    public SuiteTestRunner() {
        this(System.err);
    }

    public SuiteTestRunner(PrintStream writer) {
        this(new SuiteResultPrinter(writer));
    }

    public SuiteTestRunner(SuiteResultPrinter printer) {
        super(printer);
        this.printer = printer;
    }

    @Override
    public TestResult doRun(Test suite) {
        TestResult result = super.createTestResult();
        result.addListener(printer);
        this.printer.getWriter().println("-------------------------------------------------------");
        this.printer.getWriter().println(" T E S T S");
        this.printer.getWriter().println("-------------------------------------------------------");
        long startTime = System.currentTimeMillis();
        suite.run(result);
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        this.printer.print(result, runTime);
        super.pause(false);
        return result;
    }

}
