package org.txazo.test.annotation;

import org.txazo.test.SuiteTest;

/**
 * AnnotationTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 25.05.2015
 */
public class AnnotationTest extends SuiteTest {

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
    public void test() {
        println("test");
    }

    @Test(timeout = 2000)
    public void testTimeout() {
        println("testTimeout");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(expected = RuntimeException.class)
    public void testException() {
        println("testException");
    }

}
