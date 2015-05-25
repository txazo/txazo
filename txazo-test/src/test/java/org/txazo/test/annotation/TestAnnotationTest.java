package org.txazo.test.annotation;

import org.txazo.test.SuiteTest;

/**
 * TestAnnotationTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 25.05.2015
 */
public class TestAnnotationTest extends SuiteTest {

    @BeforeClass
    public static void beforeClass() {
        println("beforeClass");
    }

    @AfterClass
    public static void afterClass() {
        println("afterClass");
    }

    @Before
    public void before() {
        println("before");
    }

    @After
    public void after() {
        println("after");
    }

    @Test
    public static void test() {
        println("Test");
    }

    @Test(timeout = 1200)
    public static void testTimeout() {
    }

    @Test(expected = RuntimeException.class)
    public static void testException() {
    }

}
