package org.txazo.test;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;
import org.txazo.test.annotation.Suite;
import org.txazo.test.exception.TxazoTestException;
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

    public void run() throws TxazoTestException {
        TestRunner.run(suite());
    }

    public Test suite() throws TxazoTestException {
        TestSuite suite = new TestSuite();
        try {
            Set<Class<?>> classes = PackageUtils.getClassesWithAnnotation(basePackage, Suite.class);
            for (Class<?> clazz : classes) {
                suite.addTest(new JUnit4TestAdapter(clazz));
            }
        } catch (Exception e) {
            throw new TxazoTestException(e);
        }
        return suite;
    }

}
