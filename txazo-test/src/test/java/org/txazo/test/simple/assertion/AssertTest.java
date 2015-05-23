package org.txazo.test.simple.assertion;

import org.junit.Test;

/**
 * AssertTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.05.2015
 */
public class AssertTest {

    @Test
    public void testAssertTrue() {
        Assert.assertTrue(true);
    }

    @Test
    public void testAssertFalse() {
        Assert.assertFalse(false);
    }

    @Test
    public void testAssertEquals() {
        Assert.assertEquals("test", new String("test"));
    }

    @Test
    public void testAssertNotEquals() {
        Assert.assertNotEquals("test", "assert");
    }

    @Test
    public void testAssertNull() {
        Assert.assertNull(null);
    }

    @Test
    public void testAssertNotNull() {
        Assert.assertNotNull(1);
    }

    @Test
    public void testAssertSame() {
        Assert.assertSame("test", "test");
    }

    @Test
    public void testAssertNotSame() {
        Assert.assertNotSame("test", new String("test"));
    }

}
