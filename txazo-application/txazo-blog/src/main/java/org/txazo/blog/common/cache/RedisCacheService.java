package org.txazo.blog.common.cache;

import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * RedisCacheService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.07.2015
 */
@Component("redisCacheService")
public class RedisCacheService extends AbstractCacheService {

    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String, Object> valueOperations;

    @Override
    public void set(CacheKey key, Object value, long expireTime) {
        valueOperations.set(key.getKey(), value, expireTime, TimeUnit.SECONDS);
    }

    @Override
    public Object get(CacheKey key) {
        return valueOperations.get(key.getKey());
    }

    @Override
    public void delete(CacheKey key) {
        valueOperations.getOperations().delete(key.getKey());
    }

    public void increase(CacheKey key) {
        valueOperations.increment(key.getKey(), 1);
    }

}
