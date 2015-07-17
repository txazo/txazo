package org.txazo.wx.app.remind.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * RemindType
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.07.2015
 */
public enum RemindType {

    DIET(1, "饮食提醒"),
    TRIP(2, "出行提醒"),
    WORK(3, "工作提醒"),
    SLEEP(4, "睡眠提醒"),
    EXERCISE(5, "运动提醒");

    private int id;
    private String type;

    RemindType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public static boolean existsType(int id) {
        for (RemindType type : values()) {
            if (id == type.getId()) {
                return true;
            }
        }
        return false;
    }

    public static String value(int id) {
        for (RemindType type : values()) {
            if (id == type.getId()) {
                return type.getType();
            }
        }
        return StringUtils.EMPTY;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

}
