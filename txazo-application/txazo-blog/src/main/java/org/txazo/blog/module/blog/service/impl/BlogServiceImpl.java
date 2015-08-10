package org.txazo.blog.module.blog.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.txazo.blog.module.blog.bean.Blog;
import org.txazo.blog.module.blog.dao.BlogDao;
import org.txazo.blog.module.blog.service.BlogService;

/**
 * BlogServiceImpl
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.08.2015
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Override
    public boolean addBlog(Blog blog) {
        if (checkBlog(blog)) {
            try {
                blogDao.addBlog(blog);
                return blog.getId() > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean checkBlog(Blog blog) {
        return blog != null && blog.getUserId() > 0
                && blog.getCatalogId() > 0
                && StringUtils.isNoneBlank(blog.getTitle());
    }

}
