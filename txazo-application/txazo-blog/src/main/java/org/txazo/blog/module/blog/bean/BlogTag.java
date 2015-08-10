package org.txazo.blog.module.blog.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 博客标签
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.08.2015
 */
public class BlogTag implements Serializable {

    private static final long serialVersionUID = 8718016294281680295L;

    /** id */
    private int id;
    /** 标签名 */
    private String name;
    /** 数量 */
    private int quantity;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
