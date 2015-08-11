package org.txazo.blog.module.blog.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.txazo.blog.SpringAbstractTest;
import org.txazo.blog.module.blog.bean.Blog;
import org.txazo.blog.module.blog.service.BlogService;

/**
 * BlogServiceTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.08.2015
 */
public class BlogServiceTest extends SpringAbstractTest {

    @Autowired
    private BlogService blogService;

    @Test
    public void testAddBlog() {
        Blog blog = new Blog();
        blog.setUserId(1);
        blog.setCatalogId(2);
        blog.setTitle("title");
        blog.setTags("1,2");
        blog.setIsPublic(1);
        Assert.assertTrue(blogService.addBlog(blog));
    }

}
