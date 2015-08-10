package org.txazo.blog.module.blog.dao;

import org.txazo.blog.module.blog.bean.BlogCatalog;

import java.util.List;

/**
 * BlogCatalogDao
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.08.2015
 */
public interface BlogCatalogDao {

    public int addCatalog(BlogCatalog catalog);

    public int updateCatalog(BlogCatalog catalog);

    public BlogCatalog getCatalog(int id);

    public int increaseCatalogQuantity(int id);

    public int decreaseCatalogQuantity(int id);

    public List<BlogCatalog> listCatalogs(int parentId);

}
