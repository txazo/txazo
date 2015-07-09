package org.txazo.wx.app.common.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * PrivilegeUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 09.07.2015
 */
public abstract class PrivilegeUtils {

    private static final String SECRET_KEY = "!@#$%1218";

    public static boolean checkPrivilege(int needPrivilege, int userPrivilege) {
        return (needPrivilege & userPrivilege) == needPrivilege;
    }

    public static String generateLoginKey(int userId, String code) {
        return DigestUtils.md5Hex(code + SECRET_KEY + userId);
    }

}
