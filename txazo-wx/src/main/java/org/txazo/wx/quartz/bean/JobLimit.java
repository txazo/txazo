package org.txazo.wx.quartz.bean;

import java.util.Date;

/**
 * JobLimit
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 11.06.2015
 */
public class JobLimit {

    /** 开始时间 */
    private Date beginTime;
    /** 结束时间 */
    private Date endTime;
    /** 总次数 */
    private int totalTimes;

    public JobLimit(Date beginTime, Date endTime, int totalTimes) {
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.totalTimes = totalTimes;
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

    public int getTotalTimes() {
        return totalTimes;
    }

    public void setTotalTimes(int totalTimes) {
        this.totalTimes = totalTimes;
    }

}
