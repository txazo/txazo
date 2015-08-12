package org.txazo.blog.module.register.util;

import java.util.regex.Pattern;

/**
 * RegisterUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.08.2015
 */
public abstract class RegisterUtils {

    private static final String REGEX_EMAIL = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";
    private static final String REGEX_USERNAME = ".{4,12}";
    private static final String REGEX_PASSWORD = "\\w{6,18}";

    public static boolean isValidEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }

    public static boolean isValidUserName(String userName) {
        return Pattern.matches(REGEX_USERNAME, userName);
    }

    public static boolean isValidPassWord(String passWord) {
        return Pattern.matches(REGEX_PASSWORD, passWord);
    }

}
