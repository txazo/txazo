package org.txazo.wx.cache;

import org.junit.Assert;
import org.junit.Test;
import org.txazo.wx.SpringAbstractTest;

import javax.annotation.Resource;

/**
 * EhCacheCacheServiceTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.07.2015
 */
public class EhCacheCacheServiceTest extends SpringAbstractTest {

    @Resource
    private CacheService ehCacheCacheService;

    @Test
    public void test() {
        ehCacheCacheService.set("ehcache", "ehcache");
        Assert.assertEquals("ehcache", ehCacheCacheService.get("ehcache", String.class));
        ehCacheCacheService.delete("ehcache");
    }

    @Test
    public void testElementLiveTime() throws InterruptedException {
        ehCacheCacheService.set("ehcache", "ehcache", 3);
        Thread.sleep(1000);
        Assert.assertNotNull(ehCacheCacheService.get("ehcache"));
        Thread.sleep(3000);
        Assert.assertNull(ehCacheCacheService.get("ehcache"));
    }

}
