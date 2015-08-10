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
    public void set(String key, Object value, long expireTime) {
        memcachedClient.set(key, (int) expireTime, value);
    }

    @Override
    public Object get(String key) {
        return memcachedClient.get(key);
    }


    @Override
    public void delete(String key) {
        memcachedClient.delete(key);
    }

}
