package org.txazo.blog.common.util;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * CodeUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.08.2015
 */
public abstract class CodeUtils {

    private static final String CHARS = "0123456789abcdefghijklmnopqrstuvwxyz";

    public static String generateCode(int length) {
        return RandomStringUtils.random(length, CHARS);
    }

}
