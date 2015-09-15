package org.txazo.blog.common.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.txazo.blog.module.user.bean.User;

/**
 * LoginUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.08.2015
 */
public abstract class LoginUtils {

    public static final String COOKIE_USER_ID = "user_id";
    public static final String COOKIE_LOGIN_KEY = "login_key";

    public static String generateLoginKey(int userId, String code) {
        return md5AndSha1Hex(StringUtils.merge(String.valueOf(userId), code));
    }

    public static String generatePassWord(String passWord, String encryptKey) {
        return md5AndSha1Hex(StringUtils.merge(passWord, encryptKey)).substring(8, 24);
    }

    public static boolean login(User user, String passWord) {
        return generatePassWord(passWord, user.getEncryptKey()).equals(user.getPassWord());
    }

    private static String md5AndSha1Hex(String text) {
        return DigestUtils.md5Hex(DigestUtils.sha1Hex(text));
    }

}
