package org.txazo.wx.app.common.enums;

/**
 * PrivilegeType
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 30.06.2015
 */
public enum PrivilegeType {

    ADMIN(0xffff, false, "管理员"),
    UNLIMIT(0x1000, false, "不限用户"),
    LOGIN(0x0001, true, "登陆用户"),
    USER(0x0002, false, "用户管理"),
    EMAIL(0x0004, true, "邮件提醒"),
    MEMORY(0x0008, true, "技术要点"),
    REMIND(0x0010, true, "提醒事项");

    private int id;
    private boolean visible;
    private String title;

    PrivilegeType(int id, boolean visible, String title) {
        this.id = id;
        this.visible = visible;
        this.title = title;
    }

    public static boolean isValidPrivilege(Integer privilege) {
        if (privilege != null) {
            for (PrivilegeType privilegeType : values()) {
                if (privilegeType.getId() == privilege) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public boolean isVisible() {
        return visible;
    }

    public String getTitle() {
        return title;
    }

}
