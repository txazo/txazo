package org.txazo.test.runner;

import org.txazo.test.annotation.Test;
import org.txazo.test.assertion.Assert;

/**
 * TestExecuorTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 22.05.2015
 */
public class TestExecuorTest {

    @Test
    public void testGetInstance() throws InstantiationException, IllegalAccessException {
        TestExecuorTest test1 = TestExecuor.getInstance(TestExecuorTest.class);
        TestExecuorTest test2 = TestExecuor.getInstance(TestExecuorTest.class);
        Assert.assertSame(test1, test2);
        Assert.assertSame(test1.getClass(), TestExecuorTest.class);
    }

}
