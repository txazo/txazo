package org.txazo.wx.cache;

import org.junit.Assert;
import org.junit.Test;
import org.txazo.wx.SpringAbstractTest;

import javax.annotation.Resource;

/**
 * RedisCacheServiceTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.07.2015
 */
public class RedisCacheServiceTest extends SpringAbstractTest {

    @Resource
    private CacheService redisCacheService;

    @Test
    public void test() {
        redisCacheService.set("redis", "redis");
        Assert.assertEquals("redis", redisCacheService.get("redis", String.class));
        redisCacheService.delete("redis");
    }

}
