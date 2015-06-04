package org.txazo.wx.application.remind.enums;

/**
 * RepeatEndType
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 04.06.2015
 */
public enum RepeatEndType {

    REPEAT_FOREVER(1, "无限重复"),
    UP_TO_DATE(2, "截至日期"),
    LIMIT_TIMES(3, "限制次数");

    private int id;
    private String description;

    RepeatEndType(int id, String description) {
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
