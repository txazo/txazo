package org.txazo.framework.util;

public abstract class Assert {

    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void notEmpty(final CharSequence cs, String message) {
        if (cs == null || cs.length() == 0) {
            throw new IllegalArgumentException(message);
        }
    }

}
