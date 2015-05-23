package org.txazo.test.simple.runner;

import org.txazo.test.simple.*;
import org.txazo.test.simple.assertion.Assert;

public class SimpleTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("afterClass");
    }

    @Before
    public void before() {
        System.out.println("before");
    }

    @After
    public void after() {
        System.out.println("after");
    }

    @Test
    public void testSuccess() {
        System.out.println("test");
    }

    @Test
    public void testFailure() {
        Assert.assertTrue(false);
    }

    @Test
    public void testError() {
        throw new RuntimeException();
    }

}
