package org.txazo.blog.common.cache;

/**
 * AbstractCacheService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.07.2015
 */
public abstract class AbstractCacheService implements CacheService {

    private static final int defaultExpireTime = 600;

    @Override
    public void set(String key, Object value) {
        set(key, value, defaultExpireTime);
    }

    @Override
    public <T> T get(String key, Class<T> clazz) {
        return (T) get(key);
    }

}
