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
    /** 标题 */
    private String title;
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

}
