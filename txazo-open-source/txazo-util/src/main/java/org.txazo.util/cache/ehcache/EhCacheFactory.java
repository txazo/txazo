package org.txazo.util.cache.ehcache;

import net.sf.ehcache.CacheManager;

import java.util.HashMap;
import java.util.Map;

/**
 * EhCacheFactory
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.07.2015
 */
public abstract class EhCacheFactory {

    private static final String DEFAULT_EHCACHE_CONFIG = "ehcache.xml";
    private static Map<String, EhCacheManager> ehCacheManagerMap = new HashMap<String, EhCacheManager>();

    public static EhCacheManager getEhCacheManager() {
        return getEhCacheManager(DEFAULT_EHCACHE_CONFIG);
    }

    public static synchronized EhCacheManager getEhCacheManager(String config) {
        if (ehCacheManagerMap.containsKey(config)) {
            return ehCacheManagerMap.get(config);
        }

        EhCacheManager ehCacheManager = new EhCacheManager(CacheManager.newInstance(config));
        ehCacheManagerMap.put(config, ehCacheManager);
        return ehCacheManager;
    }

}
