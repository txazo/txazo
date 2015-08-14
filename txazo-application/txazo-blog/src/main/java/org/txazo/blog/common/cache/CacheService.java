package org.txazo.blog.common.cache;

/**
 * CacheService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.07.2015
 */
public interface CacheService {

    public void set(CacheKey key, Object value);

    public void set(CacheKey key, Object value, long expireTime);

    public Object get(CacheKey key);

    public <T> T get(CacheKey key, Class<T> clazz);

    public void delete(CacheKey key);

}
