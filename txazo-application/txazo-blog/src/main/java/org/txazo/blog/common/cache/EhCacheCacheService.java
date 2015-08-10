package org.txazo.blog.common.cache;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * EhCacheCacheService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.07.2015
 */
@Component("cacheService")
public class EhCacheCacheService extends AbstractCacheService {

    @Resource
    private Ehcache ehCache;

    @Override
    public void set(String key, Object value, long expireTime) {
        ehCache.put(new Element(key, value, false, 0, (int) expireTime));
    }

    @Override
    public Object get(String key) {
        Element element = ehCache.get(key);
        return element != null ? element.getObjectValue() : null;
    }

    @Override
    public void delete(String key) {
        ehCache.remove(key);
    }

}
