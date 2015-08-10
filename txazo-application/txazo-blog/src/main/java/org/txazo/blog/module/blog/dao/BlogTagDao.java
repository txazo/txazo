package org.txazo.blog.module.blog.dao;

import org.txazo.blog.module.blog.bean.BlogTag;

import java.util.List;

/**
 * BlogTagDao
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.08.2015
 */
public interface BlogTagDao {

    public int addTag(BlogTag tag);

    public int updateTag(BlogTag tag);

    public int increaseTagQuantity(int id);

    public int decreaseTagQuantity(int id);

    public List<BlogTag> getHotTags();

}
