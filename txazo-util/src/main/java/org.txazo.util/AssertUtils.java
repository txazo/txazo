package org.txazo.util;

/**
 * 断言工具类
 *
 * @author txazo
 * @email txazo1218@163.com
 * @qq 784990655
 * @since 05.05.2015
 */
public abstract class AssertUtils {

    /**
     * 为空
     */
    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 为空
     */
    public static void isNull(Object object) {
        isNull(object, "the object argument must be null");
    }

    /**
     * 不为空
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    /**
     * 不为空
     */
    public static void notNull(Object object) {
        notNull(object, "this argument is required; it must not be null");
    }

}
