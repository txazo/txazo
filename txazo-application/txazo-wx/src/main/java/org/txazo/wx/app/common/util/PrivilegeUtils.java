package org.txazo.wx.app.common.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.txazo.wx.app.common.bean.PrivilegeDisplay;
import org.txazo.wx.app.common.enums.PrivilegeType;

import java.util.ArrayList;
import java.util.List;

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

    public static List<PrivilegeDisplay> getPrivilegeDisplays(int userPrivilege) {
        List<PrivilegeDisplay> privilegeDisplays = new ArrayList<PrivilegeDisplay>();
        for (PrivilegeType privilege : PrivilegeType.values()) {
            if (privilege.isVisible()) {
                privilegeDisplays.add(new PrivilegeDisplay(userPrivilege, privilege));
            }
        }
        return privilegeDisplays;
    }

    public static int getPrivilege(Integer[] privilege) {
        int result = 0;
        if (ArrayUtils.isNotEmpty(privilege)) {
            for (Integer p : privilege) {
                if (PrivilegeType.isValidPrivilege(p)) {
                    result |= p;
                }
            }
        }
        return result;
    }

}
