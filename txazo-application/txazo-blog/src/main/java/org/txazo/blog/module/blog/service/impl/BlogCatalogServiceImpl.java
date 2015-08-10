package org.txazo.blog.module.blog.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.txazo.blog.module.blog.bean.BlogCatalog;
import org.txazo.blog.module.blog.dao.BlogCatalogDao;
import org.txazo.blog.module.blog.service.BlogCatalogService;

import java.util.Collections;
import java.util.List;

/**
 * BlogCatalogServiceImpl
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.08.2015
 */
@Service
public class BlogCatalogServiceImpl implements BlogCatalogService {

    @Autowired
    private BlogCatalogDao blogCatalogDao;

    @Override
    public boolean addCatalog(BlogCatalog catalog) {
        if (checkBlogCatalog(catalog)) {
            try {
                blogCatalogDao.addCatalog(catalog);
                return catalog.getId() > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updateCatalog(BlogCatalog catalog) {
        if (checkBlogCatalog(catalog)) {
            try {
                return blogCatalogDao.updateCatalog(catalog) > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public BlogCatalog getCatalog(int id) {
        return blogCatalogDao.getCatalog(id);
    }

    private boolean checkBlogCatalog(BlogCatalog blogCatalog) {
        return blogCatalog != null && StringUtils.isNotBlank(blogCatalog.getName());
    }

    @Override
    public boolean increaseCatalogQuantity(int id) {
        return blogCatalogDao.increaseCatalogQuantity(id) > 0;
    }

    @Override
    public boolean decreaseCatalogQuantity(int id) {
        return blogCatalogDao.decreaseCatalogQuantity(id) > 0;
    }

    @Override
    public List<BlogCatalog> listCatalogs(int parentId) {
        List<BlogCatalog> catalogs = blogCatalogDao.listCatalogs(parentId);
        return catalogs != null ? catalogs : Collections.EMPTY_LIST;
    }

}
