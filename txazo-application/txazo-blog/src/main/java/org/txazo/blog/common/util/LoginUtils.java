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
        return md5AndSha1Hex(merge(String.valueOf(userId), code));
    }

    public static String generatePassWord(String passWord, String encryptKey) {
        return md5AndSha1Hex(merge(passWord, encryptKey)).substring(8, 24);
    }

    public static boolean login(User user, String passWord) {
        return generatePassWord(passWord, user.getEncryptKey()).equals(user.getPassWord());
    }

    private static String md5AndSha1Hex(String text) {
        return DigestUtils.md5Hex(DigestUtils.sha1Hex(text));
    }

    private static String merge(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return s1 + s2;
        }
        StringBuilder result = new StringBuilder();
        int length = Math.min(s1.length(), s2.length());
        for (int i = 0; i < length; i++) {
            result.append(s1.charAt(i)).append(s2.charAt(i));
        }
        for (int i = length; i < s1.length(); i++) {
            result.append(s1.charAt(i));
        }
        for (int i = length; i < s2.length(); i++) {
            result.append(s2.charAt(i));
        }
        return result.toString();
    }

}
