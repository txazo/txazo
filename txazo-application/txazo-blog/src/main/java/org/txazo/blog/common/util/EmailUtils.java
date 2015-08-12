package org.txazo.blog.common.util;

import java.util.regex.Pattern;

/**
 * EmailUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.08.2015
 */
public abstract class EmailUtils {

    private static final String REGEX_EMAIL = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";

    /**
     * 验证Email
     *
     * @param email 电子邮件地址
     * @return
     */
    public static boolean isValidEmail(String email) {
        return Pattern.matches(REGEX_EMAIL, email);
    }

}
