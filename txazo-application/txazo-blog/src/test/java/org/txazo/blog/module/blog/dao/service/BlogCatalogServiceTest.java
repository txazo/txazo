package org.txazo.blog.module.blog.dao.service;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.txazo.blog.SpringAbstractTest;
import org.txazo.blog.module.blog.bean.BlogCatalog;
import org.txazo.blog.module.blog.service.BlogCatalogService;

/**
 * BlogTagServiceTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.08.2015
 */
public class BlogCatalogServiceTest extends SpringAbstractTest {

    @Autowired
    private BlogCatalogService blogCatalogService;

    @Test
    public void testAddCatalog() {
        BlogCatalog catalog = new BlogCatalog();
        catalog.setParentId(0);
        catalog.setName("Java IO");
        Assert.assertTrue(blogCatalogService.addCatalog(catalog));
    }

    @Test
    public void testUpdateCatalog() {
        BlogCatalog catalog = new BlogCatalog();
        catalog.setId(1);
        catalog.setName("Java API");
        Assert.assertTrue(blogCatalogService.updateCatalog(catalog));
    }

    @Test
    public void testGetCatalog() {
        Assert.assertNotNull(blogCatalogService.getCatalog(1));
    }

    @Test
    public void testIncreaseCatalogQuantity() {
        Assert.assertTrue(blogCatalogService.increaseCatalogQuantity(1));
    }

    @Test
    public void testDecreaseCatalogQuantity() {
        Assert.assertTrue(blogCatalogService.decreaseCatalogQuantity(1));
    }

    @Test
    public void testListCatalogs() {
        Assert.assertTrue(CollectionUtils.isNotEmpty(blogCatalogService.listCatalogs(0)));
    }

}
