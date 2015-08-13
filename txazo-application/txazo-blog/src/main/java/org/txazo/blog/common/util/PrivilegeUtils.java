package org.txazo.blog.common.util;

import org.txazo.blog.common.enums.PrivilegeType;

/**
 * PrivilegeUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 09.07.2015
 */
public abstract class PrivilegeUtils {

    private static final String ADMIN_EMAIL = "txazo1218@163.com";

    public static boolean checkPrivilege(int needPrivilege, int userPrivilege) {
        return (needPrivilege & userPrivilege) == needPrivilege;
    }

    public static PrivilegeType generatePrivilege(String email) {
        return ADMIN_EMAIL.equals(email) ? PrivilegeType.ADMIN : PrivilegeType.EMAIL;
    }

}
