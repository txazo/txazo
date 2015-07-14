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

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

}
