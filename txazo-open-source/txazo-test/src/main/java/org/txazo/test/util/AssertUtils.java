package org.txazo.test.util;

import org.txazo.test.exception.TestException;

/**
 * AssertUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 21.05.2015
 */
public abstract class AssertUtils {

    public static void assertNotNull(Object... objs) {
        if (objs == null) {
            throw new TestException("args is null");
        }
        for (Object obj : objs) {
            if (obj == null) {
                throw new TestException("args is null");
            }
        }
    }

    public static void assertNotBlank(String... strs) {
        if (strs == null) {
            throw new TestException("args is blank");
        }
        for (String str : strs) {
            if (StringUtils.isBlank(str)) {
                throw new TestException("args is blank");
            }
        }
    }

}
