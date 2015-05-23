package org.txazo.test.simple.result;

import org.apache.commons.collections4.CollectionUtils;
import org.txazo.test.simple.listener.SuiteTestListener;
import org.txazo.test.simple.listener.TestListener;

import java.io.PrintStream;
import java.util.List;

/**
 * SuiteTestResult
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public class SuiteTestResult extends AbstractTestResult {

    public SuiteTestResult(PrintStream writer, TestListener listener) {
        super(writer, listener);
    }

    @Override
    public void printResult() {
        printFailures();
        printErrors();
    }

    private void printFailures() {
        printTestFailures(((SuiteTestListener) listener).getTestFailures(), "failure");
    }

    private void printErrors() {
        printTestFailures(((SuiteTestListener) listener).getTestErrors(), "error");
    }

    private void printTestFailures(List<TestFailure> testFailures, String type) {
        if (CollectionUtils.isNotEmpty(testFailures)) {
            int count = testFailures.size();
            writer.print("There ");
            writer.print(count == 1 ? "was" : "were");
            writer.print(" " + count + " " + type);
            writer.println(count == 1 ? ":" : "s:");
            for (int i = 0; i < count; i++) {
                printTestFailure(testFailures.get(i), i + 1);
            }
        }
    }

    private void printTestFailure(TestFailure failure, int index) {
        printTestFailureHeader(failure, index);
        printTestFailureFooter(failure);
    }

    private void printTestFailureHeader(TestFailure failure, int index) {
        writer.println(index + ") " + failure.getTest());
    }

    private void printTestFailureFooter(TestFailure failure) {
        failure.getThrowable().printStackTrace(writer);
    }

}
