package org.txazo.weixin.util;

import org.apache.commons.lang3.StringUtils;

/**
 * AssertUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public abstract class AssertUtils {

    public static void assertNotNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void assertNotNull(Object... objs) {
        if (objs == null) {
            throw new IllegalArgumentException("args is null");
        }
        for (Object obj : objs) {
            if (obj == null) {
                throw new IllegalArgumentException("args is null");
            }
        }
    }

    public static void assertNotBlank(String... strs) {
        if (strs == null) {
            throw new IllegalArgumentException("args is blank");
        }
        for (String str : strs) {
            if (StringUtils.isBlank(str)) {
                throw new IllegalArgumentException("args is blank");
            }
        }
    }

}
