package org.txazo.wx.cache;

import net.spy.memcached.MemcachedClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * MemcachedCacheService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 08.07.2015
 */
@Component("cacheService")
public class MemcachedCacheService implements CacheService {

    @Resource
    protected MemcachedClient spyMemcached;

    @Override
    public void set(String key, Object value, long expireTime) {
        spyMemcached.set(key, (int) expireTime, value);
    }

    @Override
    public <T> T get(String key, Class<T> clazz) {
        return (T) spyMemcached.get(key);
    }

    @Override
    public void delete(String key) {
        spyMemcached.delete(key);
    }

}
