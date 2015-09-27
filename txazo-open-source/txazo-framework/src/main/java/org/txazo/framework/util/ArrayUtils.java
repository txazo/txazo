package org.txazo.framework.util;

public abstract class ArrayUtils {

    public static <T> boolean isEmpty(final T[] array) {
        return array == null || array.length == 0;
    }

    public static <T> boolean isNotEmpty(final T[] array) {
        return !isEmpty(array);
    }

}
