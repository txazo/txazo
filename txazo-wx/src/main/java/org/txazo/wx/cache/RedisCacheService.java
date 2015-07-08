package org.txazo.wx.cache;

import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * RedisCacheService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.07.2015
 */
@Component
public class RedisCacheService implements CacheService {

    //    @Resource(name = "stringRedisTemplate")
    private ValueOperations<String, Object> valueOperations;

    public void set(String key, Object value, long expireTime) {
        valueOperations.set(key, value, expireTime);
    }

    public <T> T get(String key, Class<T> clazz) {
        return (T) valueOperations.get(key);
    }

    public void delete(String key) {
        valueOperations.getOperations().delete(key);
    }

}
