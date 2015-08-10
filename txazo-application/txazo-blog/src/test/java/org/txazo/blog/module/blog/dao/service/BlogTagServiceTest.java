package org.txazo.blog.module.blog.dao.service;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.txazo.blog.SpringAbstractTest;
import org.txazo.blog.module.blog.bean.BlogTag;
import org.txazo.blog.module.blog.service.BlogTagService;

/**
 * BlogTagServiceTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.08.2015
 */
public class BlogTagServiceTest extends SpringAbstractTest {

    @Autowired
    private BlogTagService blogTagService;

    @Test
    public void testAddTag() {
        BlogTag tag = new BlogTag();
        tag.setName("Java");
        Assert.assertTrue(blogTagService.addTag(tag));
    }

    @Test
    public void testUpdateTag() {
        BlogTag tag = new BlogTag();
        tag.setId(1);
        tag.setName("java");
        Assert.assertTrue(blogTagService.updateTag(tag));
    }

    @Test
    public void testIncreaseTagQuantity() {
        Assert.assertTrue(blogTagService.increaseTagQuantity(1));
    }

    @Test
    public void testDecreaseTagQuantity() {
        Assert.assertTrue(blogTagService.decreaseTagQuantity(1));
    }

    @Test
    public void testGetTagHots() {
        Assert.assertTrue(CollectionUtils.isNotEmpty(blogTagService.getHotTags()));
        Assert.assertTrue(CollectionUtils.isNotEmpty(blogTagService.getHotTags()));
    }

}
