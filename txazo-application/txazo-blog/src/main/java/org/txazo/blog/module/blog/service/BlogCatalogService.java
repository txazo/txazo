package org.txazo.blog.module.blog.service;

import org.txazo.blog.module.blog.bean.BlogCatalog;

import java.util.List;

/**
 * BlogCatalogService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.08.2015
 */
public interface BlogCatalogService {

    public boolean addCatalog(BlogCatalog catalog);

    public boolean updateCatalog(BlogCatalog catalog);

    public BlogCatalog getCatalog(int id);

    public boolean increaseCatalogQuantity(int id);

    public boolean decreaseCatalogQuantity(int id);

    public List<BlogCatalog> listCatalogs(int parentId);

}
