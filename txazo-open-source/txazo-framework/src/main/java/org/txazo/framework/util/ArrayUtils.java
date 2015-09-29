package org.txazo.framework.util;

import java.util.Collections;
import java.util.Enumeration;

public class ArrayUtils {

    public static final String[] EMPTY_STRING = new String[0];

    public static <T> boolean isEmpty(final T[] array) {
        return array == null || array.length == 0;
    }

    public static <T> boolean isNotEmpty(final T[] array) {
        return !isEmpty(array);
    }

    public static String[] toArray(Enumeration<String> enumeration) {
        if (enumeration == null) {
            return EMPTY_STRING;
        }
        return Collections.list(enumeration).toArray(EMPTY_STRING);
    }

}
