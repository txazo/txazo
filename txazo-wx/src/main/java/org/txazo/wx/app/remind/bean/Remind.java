package org.txazo.wx.app.remind.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Remind - 提醒事项
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 04.06.2015
 */
public class Remind implements Serializable {

    private static final long serialVersionUID = 9039470282185415874L;

    /** ID */
    private int id;
    /** 账号 */
    private String account;
    /** 标题 */
    private String title;
    /** 描述 */
    private String description;
    /** 时间表达式 */
    private String cronExpression;
    /** 开始时间 */
    private Date beginTime;
    /** 结束时间 */
    private Date endTime;
    /** 已提醒次数 */
    private int remindedTimes;
    /** 总次数 */
    private int totalTimes;
    /** 是否已删除(0-未删除, 1-删除) */
    private int isDeleted;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

    public void increaseRemindedTimes() {
        remindedTimes += 1;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getRemindedTimes() {
        return remindedTimes;
    }

    public void setRemindedTimes(int remindedTimes) {
        this.remindedTimes = remindedTimes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalTimes() {
        return totalTimes;
    }

    public void setTotalTimes(int totalTimes) {
        this.totalTimes = totalTimes;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
