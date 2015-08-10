package org.txazo.blog.common.cache;

/**
 * CacheService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.07.2015
 */
public interface CacheService {

    public static final int defaultExpireTime = 600;

    public void set(String key, Object value);

    public void set(String key, Object value, long expireTime);

    public Object get(String key);

    public <T> T get(String key, Class<T> clazz);

    public void delete(String key);

}
