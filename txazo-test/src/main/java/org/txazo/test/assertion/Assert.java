package org.txazo.test.assertion;

/**
 * Assert
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 23.05.2015
 */
public abstract class Assert {

    public static void assertTrue(boolean condition) {
        assertTrue(condition, "condition is false where expected true");
    }

    private static void assertTrue(boolean condition, String message) {
        if (!condition) {
            fail(message);
        }
    }

    public static void assertFalse(boolean condition) {
        assertTrue(!condition, "condition is true where expected false");
    }

    public static void fail(String message) {
        throw new AssertionFailedError(message);
    }

    public static void assertEquals(Object expected, Object actual) {
        if (!equalsRegardingNull(expected, actual)) {
            fail("expected and actual is not equal");
        }
    }

    public static void assertNotEquals(Object expected, Object actual) {
        if (equalsRegardingNull(expected, actual)) {
            fail("expected and actual is equal");
        }
    }

    private static boolean equalsRegardingNull(Object expected, Object actual) {
        return expected == null ? actual == null : isEquals(expected, actual);
    }

    private static boolean isEquals(Object expected, Object actual) {
        return expected.equals(actual);
    }

    public static void assertNull(Object object) {
        assertTrue(object == null, "object is not null where expected null");
    }

    public static void assertNotNull(Object object) {
        assertTrue(object != null, "object is null where expected not null");
    }

    public static void assertSame(Object expected, Object actual) {
        assertTrue(expected == actual, "expected and actual must be not same");
    }

    public static void assertNotSame(Object expected, Object actual) {
        assertTrue(expected != actual, "expected and actual must be same");
    }

}
