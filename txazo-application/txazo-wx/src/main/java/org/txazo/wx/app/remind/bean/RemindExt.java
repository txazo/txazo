package org.txazo.wx.app.remind.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * RemindExt
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.07.2015
 */
public class RemindExt implements Serializable {

    private static final long serialVersionUID = 227508126074134162L;

    /** Cron表达式 */
    private String cronExpression;
    /** 开始时间 */
    private Date beginTime;
    /** 结束时间 */
    private Date endTime;
    /** 展示类型 */
    private int showType;
    /** 内容 */
    private String[] content;
    /** 下次展示内容 */
    private int next;

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public String[] getContent() {
        return content;
    }

    public void setContent(String[] content) {
        this.content = content;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getShowType() {
        return showType;
    }

    public void setShowType(int showType) {
        this.showType = showType;
    }

}
