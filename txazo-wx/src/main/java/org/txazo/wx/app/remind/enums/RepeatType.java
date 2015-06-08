package org.txazo.wx.app.remind.enums;

/**
 * RepeatType
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 04.06.2015
 */
public enum RepeatType {

    ONCE(1, "一次"),
    DAILY(2, "每天"),
    WEEKLY(3, "每周"),
    MONTHLY(4, "每月"),
    YEARLY(5, "每年");

    private int id;
    private String description;

    RepeatType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

}
