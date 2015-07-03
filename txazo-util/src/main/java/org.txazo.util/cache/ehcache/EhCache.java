package org.txazo.util.cache.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

/**
 * EhCache
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.07.2015
 */
public class EhCache {

    private Cache cache;

    EhCache(Cache cache) {
        this.cache = cache;
    }

    public void put(Object key, Object value) {
        cache.put(new Element(key, value));
    }

    public Object get(Object key) {
        Element element = cache.get(key);
        return element != null ? element.getObjectValue() : null;
    }

    public void remove(Object key) {
        cache.remove(key);
    }

}
