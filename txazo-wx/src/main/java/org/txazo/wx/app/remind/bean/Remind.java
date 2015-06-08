package org.txazo.wx.app.remind.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Remind
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 04.06.2015
 */
public class Remind implements Serializable {

    private static final long serialVersionUID = 9039470282185415874L;

    /** ID */
    private long id;
    /** 用户 */
    private String user;
    /** 提醒事项 */
    private String title;
    /** 提醒时间 */
    private Date remindTime;
    /** 提前提醒时间(分钟) */
    private int aheadRemindTime;
    /** 重复类型 */
    private int repeatType;
    /** 重复结束类型 */
    private int repeatEndType;
    /** 重复次数 */
    private int repeatTimes;
    /** 重复结束时间 */
    private Date repeatEndTime;
    /** 备注 */
    private String remark;
    /** 已提醒次数 */
    private int remindedTimes;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

    public int getAheadRemindTime() {
        return aheadRemindTime;
    }

    public void setAheadRemindTime(int aheadRemindTime) {
        this.aheadRemindTime = aheadRemindTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getRemindedTimes() {
        return remindedTimes;
    }

    public void setRemindedTimes(int remindedTimes) {
        this.remindedTimes = remindedTimes;
    }

    public Date getRemindTime() {
        return remindTime;
    }

    public void setRemindTime(Date remindTime) {
        this.remindTime = remindTime;
    }

    public Date getRepeatEndTime() {
        return repeatEndTime;
    }

    public void setRepeatEndTime(Date repeatEndTime) {
        this.repeatEndTime = repeatEndTime;
    }

    public int getRepeatEndType() {
        return repeatEndType;
    }

    public void setRepeatEndType(int repeatEndType) {
        this.repeatEndType = repeatEndType;
    }

    public int getRepeatTimes() {
        return repeatTimes;
    }

    public void setRepeatTimes(int repeatTimes) {
        this.repeatTimes = repeatTimes;
    }

    public int getRepeatType() {
        return repeatType;
    }

    public void setRepeatType(int repeatType) {
        this.repeatType = repeatType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
