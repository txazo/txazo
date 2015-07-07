package org.txazo.wx.app.common.enums;

/**
 * PrivilegeType
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 30.06.2015
 */
public enum PrivilegeType {

    ADMIN(0xffff, "管理员"),
    UNLIMIT(0x1000, "无限制"),
    LOGIN(0x0001, "登陆用户"),
    EMAIL(0x0002, "邮件"),
    MEMORY(0x0004, "Technology"),
    REMIND(0x0008, "提醒");

    private int id;
    private String title;

    PrivilegeType(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}
