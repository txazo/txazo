package org.txazo.blog.module.blog.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.txazo.blog.common.cache.CacheKey;
import org.txazo.blog.common.cache.CacheService;
import org.txazo.blog.common.constant.Key;
import org.txazo.blog.module.blog.bean.BlogTag;
import org.txazo.blog.module.blog.dao.BlogTagDao;
import org.txazo.blog.module.blog.service.BlogTagService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * BlogTagServiceImpl
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.08.2015
 */
@Service
public class BlogTagServiceImpl implements BlogTagService {

    @Autowired
    private BlogTagDao blogTagDao;

    @Resource
    private CacheService cacheService;

    @Override
    public boolean addTag(BlogTag tag) {
        if (checkTag(tag)) {
            try {
                blogTagDao.addTag(tag);
                return tag.getId() > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updateTag(BlogTag tag) {
        if (checkTag(tag)) {
            try {
                return blogTagDao.updateTag(tag) > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean checkTag(BlogTag tag) {
        return tag != null && StringUtils.isNotBlank(tag.getName());
    }

    @Override
    public boolean increaseTagQuantity(int id) {
        return blogTagDao.increaseTagQuantity(id) > 0;
    }

    @Override
    public boolean decreaseTagQuantity(int id) {
        return blogTagDao.decreaseTagQuantity(id) > 0;
    }

    @Override
    public List<BlogTag> getHotTags() {
        CacheKey key = new CacheKey(Key.BLOG_TAG_HOTS);
        List<BlogTag> hots = (List<BlogTag>) cacheService.get(key);
        if (hots == null) {
            hots = blogTagDao.getHotTags();
            if (hots == null) {
                hots = new ArrayList<BlogTag>();
            }
            cacheService.set(key, hots);
        }
        return hots;
    }

}
