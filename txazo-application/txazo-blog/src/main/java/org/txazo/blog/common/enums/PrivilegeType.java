package org.txazo.blog.common.enums;

/**
 * 权限
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 30.06.2015
 */
public enum PrivilegeType {

    ADMIN(0xffff),
    MANAGER(0x0fff),
    LOGIN(0x0001),
    EMAIL(0x0001),
    UNLIMIT(0x0000);

    private int id;

    PrivilegeType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
