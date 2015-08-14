package org.txazo.blog.common.cache;

/**
 * AbstractCacheService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.07.2015
 */
public abstract class AbstractCacheService implements CacheService {

    private static final int DEFAULT_EXPIRE_TIME = 600;

    @Override
    public void set(CacheKey key, Object value) {
        set(key, value, DEFAULT_EXPIRE_TIME);
    }

    @Override
    public <T> T get(CacheKey key, Class<T> clazz) {
        return (T) get(key);
    }

}
