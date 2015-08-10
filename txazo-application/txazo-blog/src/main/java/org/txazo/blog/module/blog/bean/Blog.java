package org.txazo.blog.module.blog.bean;

import java.util.Date;

/**
 * 博客
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.08.2015
 */
public class Blog {

    /** id */
    private int id;
    /** 用户id */
    private int userId;
    /** 目录id */
    private int catalogId;
    /** 标题 */
    private String title;
    /** 标签 */
    private String tags;
    /** 浏览次数 */
    private int viewCount;
    /** 是否公开 */
    private int isPublic;
    /** 是否删除 */
    private int idDeleted;
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

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(int isPublic) {
        this.isPublic = isPublic;
    }

    public int getIdDeleted() {
        return idDeleted;
    }

    public void setIdDeleted(int idDeleted) {
        this.idDeleted = idDeleted;
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
