package org.txazo.wx.cache;

import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CacheService {

    @Resource(name = "stringRedisTemplate")
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
