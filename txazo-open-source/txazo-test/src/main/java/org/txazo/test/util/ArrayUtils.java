package org.txazo.test.util;

import java.lang.reflect.Array;

/**
 * ArrayUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 25.05.2015
 */
public abstract class ArrayUtils {

    public static boolean isEmpty(final Object[] array) {
        return getLength(array) == 0;
    }

    public static boolean isNotEmpty(final Object[] array) {
        return !isEmpty(array);
    }

    public static int getLength(final Object array) {
        if (array == null) {
            return 0;
        }
        return Array.getLength(array);
    }

}
