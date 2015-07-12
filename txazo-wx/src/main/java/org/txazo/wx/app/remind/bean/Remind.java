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

    /** id */
    private int id;
    /** 用户名 */
    private String userName;
    /** 类型 */
    private int type;
    private String title;
    private String content;
    private int totalTimes;
    private String cronExpression;
    private int remindedTimes;
    /** 扩展 */
    private RemindExt ext;
    /** 开始时间 */
    private Date beginTime;
    /** 结束时间 */
    private Date endTime;
    /** 状态, 0－启用, 1－停用 */
    private int status;
    /** 是否删除, 0－否, 1－是 */
    private int isDeleted;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

    public Remind() {
    }

    public void increaseRemindedTimes() {

    }

    public String getMessage() {
        return null;
    }

    public int getTotalTimes() {
        return totalTimes;
    }

    public void setTotalTimes(int totalTimes) {
        this.totalTimes = totalTimes;
    }

    public int getRemindedTimes() {
        return remindedTimes;
    }

    public void setRemindedTimes(int remindedTimes) {
        this.remindedTimes = remindedTimes;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public RemindExt getExt() {
        return ext;
    }

    public void setExt(RemindExt ext) {
        this.ext = ext;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
