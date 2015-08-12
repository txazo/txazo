package org.txazo.blog.common.util;

/**
 * PrivilegeUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 09.07.2015
 */
public abstract class PrivilegeUtils {

    public static boolean checkPrivilege(int needPrivilege, int userPrivilege) {
        return (needPrivilege & userPrivilege) == needPrivilege;
    }

}
