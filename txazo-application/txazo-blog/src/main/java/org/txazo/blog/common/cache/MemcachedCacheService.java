package org.txazo.blog.common.cache;

import net.spy.memcached.MemcachedClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * MemcachedCacheService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.07.2015
 */
@Component("memcachedCacheService")
public class MemcachedCacheService extends AbstractCacheService {

    @Resource
    protected MemcachedClient memcachedClient;

    @Override
    public void set(CacheKey key, Object value, long expireTime) {
        memcachedClient.set(key.getKey(), (int) expireTime, value);
    }

    @Override
    public Object get(CacheKey key) {
        return memcachedClient.get(key.getKey());
    }

    @Override
    public void delete(CacheKey key) {
        memcachedClient.delete(key.getKey());
    }

}
