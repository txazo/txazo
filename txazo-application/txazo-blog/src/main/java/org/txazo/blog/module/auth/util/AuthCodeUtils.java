package org.txazo.blog.module.auth.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * AuthCodeUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 13.08.2015
 */
public abstract class AuthCodeUtils {

    private static final String RANDOM_CHAR = "0123456789abcdefghijklmnopqrstuvwxyz";

    public static String generateCode() {
        return DigestUtils.md5Hex((RandomStringUtils.random(18, RANDOM_CHAR)));
    }

}
