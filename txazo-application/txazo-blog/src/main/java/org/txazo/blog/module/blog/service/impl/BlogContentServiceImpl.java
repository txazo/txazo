package org.txazo.blog.module.blog.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.txazo.blog.module.blog.bean.BlogContent;
import org.txazo.blog.module.blog.dao.BlogContentDao;
import org.txazo.blog.module.blog.service.BlogContentService;

/**
 * BlogContentServiceImpl
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.08.2015
 */
@Service
public class BlogContentServiceImpl implements BlogContentService {

    @Autowired
    private BlogContentDao blogContentDao;

    @Override
    public boolean addContent(BlogContent content) {
        if (checkBlogContent(content)) {
            try {
                blogContentDao.addContent(content);
                return content.getId() > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updateContent(BlogContent content) {
        if (checkBlogContent(content)) {
            try {
                return blogContentDao.updateContent(content) > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean checkBlogContent(BlogContent content) {
        return content != null && StringUtils.isNoneBlank(content.getContent());
    }

    @Override
    public BlogContent getContent(int id) {
        return blogContentDao.getContent(id);
    }

    @Override
    public boolean changeContentStatus(int id, int status) {
        return blogContentDao.changeContentStatus(id, status) > 0;
    }

}
