package org.txazo.wx.app.remind.enums;

/**
 * RemindShowType
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.07.2015
 */
public enum RemindShowType {

    SINGLE(1, "单个提醒"),
    RANDOM(2, "顺序提醒"),
    SEQUENCE(3, "随机提醒");

    private int id;
    private String type;

    RemindShowType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

}
