package org.txazo.test.simple.runner;

import org.txazo.test.simple.*;
import org.txazo.test.simple.assertion.Assert;

public class SimpleTest {

    @BeforeClass
    public static void beforeClass() {
        //System.out.println("beforeClass");
        String str = null;
        String a = str.toString();
    }

    @AfterClass
    public static void afterClass() {
        //System.out.println("afterClass");
    }

    @Before
    public void before() {
        //System.out.println("before");
    }

    @After
    public void after() {
        // System.out.println("after");
    }

    @Test
    public void test1() {
        // System.out.println("test1");
        //throw new RuntimeException();
        int a = 1 / 0;
    }

    @Test
    public void test2() {
        //System.out.println("test2");
    }

    @Test
    public void test3() {
        Assert.assertTrue(false);
    }

}
