package org.txazo.wx.app.remind.bean;

import java.io.Serializable;

/**
 * RemindExt
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.07.2015
 */
public class RemindExt implements Serializable {

    /** Cron表达式 */
    private String cronExpression;
    /** 展示类型 */
    private int showType;
    /** 内容 */
    private String[] content;

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public int getShowType() {
        return showType;
    }

    public void setShowType(int showType) {
        this.showType = showType;
    }

    public String[] getContent() {
        return content;
    }

    public void setContent(String[] content) {
        this.content = content;
    }

}
