package org.txazo.wx.cache;

/**
 * CacheService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.07.2015
 */
public interface CacheService {

    public void set(String key, Object value, long expireTime);

    public <T> T get(String key, Class<T> clazz);

    public void delete(String key);

}
