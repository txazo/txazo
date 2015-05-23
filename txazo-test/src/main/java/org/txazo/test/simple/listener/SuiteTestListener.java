package org.txazo.test.simple.listener;

import org.txazo.test.simple.assertion.AssertionFailedError;
import org.txazo.test.simple.result.TestFailure;
import org.txazo.test.simple.test.AbstractTest;
import org.txazo.test.simple.test.ClassTest;
import org.txazo.test.simple.test.MethodTest;
import org.txazo.test.simple.test.SuiteTest;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SuiteTestListener
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.05.2015
 */
public class SuiteTestListener extends AbstractTestListener {

    private MethodTestWriter methodWriter = new MethodTestWriter();
    private ClassTestWriter classWriter = new ClassTestWriter();
    private SuiteTestWriter suiteWriter = new SuiteTestWriter();

    private List<AbstractTest> testSuccesses = new ArrayList<AbstractTest>();
    private List<TestFailure> testErrors = new ArrayList<TestFailure>();
    private List<TestFailure> testFailures = new ArrayList<TestFailure>();

    public SuiteTestListener(PrintStream writer) {
        super(writer);
    }

    @Override
    public void testBefore(AbstractTest test) {
        if (test instanceof MethodTest) {
            methodWriter.before((MethodTest) test);
        } else if (test instanceof ClassTest) {
            classWriter.before((ClassTest) test);
        } else if (test instanceof SuiteTest) {
            suiteWriter.before((SuiteTest) test);
        }
    }

    @Override
    public void testAfter(AbstractTest test) {
        if (test instanceof MethodTest) {
            methodWriter.after((MethodTest) test);
        } else if (test instanceof ClassTest) {
            classWriter.after((ClassTest) test);
        } else if (test instanceof SuiteTest) {
            suiteWriter.after((SuiteTest) test);
        }
    }

    @Override
    public void addSuccess(AbstractTest test) {
        testSuccesses.add(test);
        print(" success");
    }

    @Override
    public void addError(AbstractTest test, Throwable throwable) {
        TestFailure failure = new TestFailure(test, throwable);
        if (failure.isFailure()) {
            addFailure(failure);
        } else {
            addError(failure);
        }
    }

    private void addError(TestFailure failure) {
        testErrors.add(failure);
        print(" error");
    }

    @Override
    public void addFailure(AbstractTest test, AssertionFailedError error) {
        addFailure(new TestFailure(test, error));
    }

    private void addFailure(TestFailure failure) {
        testFailures.add(failure);
        print(" fail");
    }

    @Override
    public void addThrowable(AbstractTest test, Throwable throwable) {
        throwable.printStackTrace(writer);
    }

    private void print(Object object) {
        writer.print(object);
    }

    private void println(Object object) {
        writer.println(object);
    }

    public List<TestFailure> getTestErrors() {
        return testErrors;
    }

    public List<TestFailure> getTestFailures() {
        return testFailures;
    }

    private interface TestWriter<T> {

        void before(T t);

        void after(T t);

    }

    private abstract class AbstractTestWriter<T> implements TestWriter<T> {

        protected Map<T, Long> runTimes = new HashMap<T, Long>();

        abstract void beforeTest(T t);

        abstract void afterTest(T t);

        @Override
        public void before(T t) {
            beforeTest(t);
            runTimes.put(t, System.currentTimeMillis());
        }

        @Override
        public void after(T t) {
            long startTime = runTimes.get(t);
            runTimes.put(t, System.currentTimeMillis() - startTime);
            afterTest(t);
        }

        public String getRunTime(T t) {
            return NumberFormat.getInstance().format((double) runTimes.get(t) / 1000.0D);
        }

    }

    private class MethodTestWriter extends AbstractTestWriter<MethodTest> {

        @Override
        public void beforeTest(MethodTest test) {
            print("\t + " + test.getMethod().getName());
        }

        @Override
        public void afterTest(MethodTest test) {
            println(" (" + getRunTime(test) + "s)");
        }

    }

    private class ClassTestWriter extends AbstractTestWriter<ClassTest> {

        @Override
        public void beforeTest(ClassTest test) {
            println(test.getClazz().getName());
        }

        @Override
        public void afterTest(ClassTest test) {
            println("----------------------------------------");
        }

    }

    private class SuiteTestWriter extends AbstractTestWriter<SuiteTest> {

        @Override
        public void beforeTest(SuiteTest test) {
            println("----------------------------------------");
            println("T E S T");
            println("----------------------------------------");
        }

        @Override
        public void afterTest(SuiteTest test) {
            println("E N D");
            print("Total: " + (testSuccesses.size() + testFailures.size() + testErrors.size()));
            print(", success (" + testSuccesses.size() + ")");
            print(", failure (" + testFailures.size() + ")");
            println(", error (" + testErrors.size() + ")");
            println("----------------------------------------");
        }

    }

}
