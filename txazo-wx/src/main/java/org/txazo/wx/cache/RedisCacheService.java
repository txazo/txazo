package org.txazo.wx.cache;

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
    public void set(String key, Object value, long expireTime) {
        valueOperations.set(key, value, expireTime, TimeUnit.SECONDS);
    }

    @Override
    public Object get(String key) {
        return valueOperations.get(key);
    }

    @Override
    public void delete(String key) {
        valueOperations.getOperations().delete(key);
    }

}
