package org.txazo.blog.module.blog.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 博客内容
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.08.2015
 */
public class BlogContent implements Serializable {

    private static final long serialVersionUID = -7303072813172384420L;

    /** id */
    private int id;
    /** 博客id */
    private int blogId;
    /** 内容 */
    private String content;
    /** 类型(1-草稿, 2-线上, 3-历史) */
    private int type;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
