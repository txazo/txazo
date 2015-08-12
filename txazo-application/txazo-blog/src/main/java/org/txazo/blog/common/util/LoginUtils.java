package org.txazo.blog.common.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * LoginUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.08.2015
 */
public abstract class LoginUtils {

    private static final String SECRET_KEY = "!#%&1218@$^*";
    private static final String RANDOM_CHAR = "0123456789abcdefghij";

    public static String generateLoginKey(int userId, String code) {
        return DigestUtils.md5Hex(code + SECRET_KEY + userId);
    }

    public static String generateEncryptKey() {
        return RandomStringUtils.random(8, RANDOM_CHAR);
    }

    public static String generatePassWord(String plainText, String encryptKey) {
        return DigestUtils.md5Hex(DigestUtils.sha1Hex(plainText) + encryptKey).substring(8, 24);
    }

}
