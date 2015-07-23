package org.txazo.wx.app.remind.enums;

/**
 * RemindShowType
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.07.2015
 */
public enum RemindShowType {

    RANDOM(1, "顺序展示"),
    SEQUENCE(2, "随机展示");

    private int id;
    private String type;

    RemindShowType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public static boolean existsType(int id) {
        for (RemindShowType type : values()) {
            if (id == type.getId()) {
                return true;
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

}
