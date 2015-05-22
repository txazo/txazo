package org.txazo.test.simple.listener;

import org.txazo.test.simple.test.AbstractTest;
import org.txazo.test.simple.test.ClassTest;
import org.txazo.test.simple.test.MethodTest;
import org.txazo.test.simple.test.SuiteTest;

import java.io.PrintStream;

/**
 * SuiteTestListener
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public class SuiteTestListener extends AbstractTestListener {

    private MethodTestWriter methodWriter = new MethodTestWriter();
    private ClassTestWriter classWriter = new ClassTestWriter();
    private SuiteTestWriter suiteWriter = new SuiteTestWriter();

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

    private void println(Object obj) {
        writer.println(obj);
    }

    interface TestWriter<T> {

        void before(T t);

        void after(T t);

    }

    abstract class AbstractTestWriter<T> implements TestWriter<T> {

    }

    class MethodTestWriter extends AbstractTestWriter<MethodTest> {

        @Override
        public void before(MethodTest test) {
            println("MethodTest before");
        }

        @Override
        public void after(MethodTest test) {
            println("MethodTest after");
        }

    }

    class ClassTestWriter extends AbstractTestWriter<ClassTest> {

        @Override
        public void before(ClassTest test) {
            println("ClassTest before");
        }

        @Override
        public void after(ClassTest test) {
            println("ClassTest after");
        }

    }

    class SuiteTestWriter extends AbstractTestWriter<SuiteTest> {

        @Override
        public void before(SuiteTest test) {
            println("SuiteTest before");
        }

        @Override
        public void after(SuiteTest test) {
            println("SuiteTest after");
        }

    }

}
