package org.txazo.blog.common.util;

/**
 * StringUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 2015-09-15
 */
public abstract class StringUtils {

    public static String merge(String s1, String s2) {
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
