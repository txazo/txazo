package org.txazo.wx.cache;

import org.junit.Assert;
import org.junit.Test;
import org.txazo.wx.SpringAbstractTest;

import javax.annotation.Resource;

/**
 * MemcachedCacheServiceTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.07.2015
 */
public class MemcachedCacheServiceTest extends SpringAbstractTest {

    @Resource
    private CacheService memcachedCacheService;

    @Test
    public void test() {
        memcachedCacheService.set("memcached", "memcached");
        Assert.assertEquals("memcached", memcachedCacheService.get("memcached", String.class));
        memcachedCacheService.delete("memcached");
    }

}
