package org.txazo.blog.module.blog.dao;

import org.apache.ibatis.annotations.Param;
import org.txazo.blog.module.blog.bean.BlogContent;

/**
 * BlogContentDao
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.08.2015
 */
public interface BlogContentDao {

    public int addContent(BlogContent content);

    public int updateContent(BlogContent content);

    public BlogContent getContent(int id);

    public BlogContent getContentByBlogAndStatus(@Param("blogId") int blogId, @Param("status") int status);

    public int changeContentStatus(@Param("id") int id, @Param("status") int status);

}
