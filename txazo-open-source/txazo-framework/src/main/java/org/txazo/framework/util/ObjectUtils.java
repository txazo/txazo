package org.txazo.framework.util;

public abstract class ObjectUtils {

    public static String identityToString(Object obj) {
        if (obj == null) {
            return StringUtils.EMPTY;
        }
        return obj.getClass().getName() + "@" + getIdentityHexString(obj);
    }

    public static String getIdentityHexString(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

}
