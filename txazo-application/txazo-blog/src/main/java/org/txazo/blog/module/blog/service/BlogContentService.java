package org.txazo.blog.module.blog.service;

import org.apache.ibatis.annotations.Param;
import org.txazo.blog.module.blog.bean.BlogContent;

/**
 * BlogContentService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.08.2015
 */
public interface BlogContentService {

    public boolean addContent(BlogContent content);

    public boolean updateContent(BlogContent content);

    public BlogContent getContent(int id);

    public boolean changeContentStatus(@Param("id") int id, @Param("status") int status);

}
