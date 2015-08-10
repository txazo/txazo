package org.txazo.blog.module.blog.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 博客目录
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.08.2015
 */
public class BlogCatalog implements Serializable {

    private static final long serialVersionUID = -3480228491594431864L;

    /** id */
    private int id;
    /** 父id */
    private int parentId;
    /** 目录名 */
    private String name;
    /** 数量 */
    private int quantity;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
