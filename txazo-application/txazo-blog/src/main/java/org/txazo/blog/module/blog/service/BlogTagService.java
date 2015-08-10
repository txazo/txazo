package org.txazo.blog.module.blog.service;

import org.txazo.blog.module.blog.bean.BlogTag;

import java.util.List;

/**
 * BlogTagService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.08.2015
 */
public interface BlogTagService {

    public boolean addTag(BlogTag tag);

    public boolean updateTag(BlogTag tag);

    public boolean increaseTagQuantity(int id);

    public boolean decreaseTagQuantity(int id);

    public List<BlogTag> getHotTags();

}
