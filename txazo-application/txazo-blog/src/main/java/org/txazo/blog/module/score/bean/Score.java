package org.txazo.blog.module.score.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Score
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 09.08.2015
 */
public class Score implements Serializable {

    /** id */
    private int id;
    /** 用户id */
    private int userId;
    /** 积分 */
    private int score;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
