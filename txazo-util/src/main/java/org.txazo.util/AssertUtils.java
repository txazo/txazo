package org.txazo.util;

/**
 * @author txazo
 * @email txazo@1218.com
 * @date 2015-05-05
 */
public abstract class AssertUtils {

    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNull(Object object) {
        isNull(object, "the object argument must be null");
    }

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notNull(Object object) {
        notNull(object, "this argument is required; it must not be null");
    }

}
