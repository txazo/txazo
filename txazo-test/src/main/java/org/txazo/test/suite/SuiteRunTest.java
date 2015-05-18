package org.txazo.test.suite;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;
import org.txazo.test.exception.TestException;
import org.txazo.test.util.PackageUtils;

import java.util.Set;

/**
 * SuiteRunTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 17.05.2015
 */
public class SuiteRunTest {

    private String basePackage;

    public SuiteRunTest(String basePackage) {
        this.basePackage = basePackage;
    }

    public void run() {
        try {
            SuiteTestRunner runner = new SuiteTestRunner();
            runner.doRun(suite());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Test suite() throws TestException {
        TestSuite suite = new TestSuite();
        try {
            Set<Class<?>> classes = PackageUtils.getClassesWithAnnotation(basePackage, Suite.class);
            for (Class<?> clazz : classes) {
                if (clazz != SuiteTest.class) {
                    suite.addTest(new JUnit4TestAdapter(clazz));
                }
            }
        } catch (Exception e) {
            throw new TestException(e);
        }
        return suite;
    }

}
