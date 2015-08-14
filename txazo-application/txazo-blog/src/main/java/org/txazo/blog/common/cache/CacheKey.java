package org.txazo.blog.common.cache;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ArrayUtils;

/**
 * CacheKey
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.07.2015
 */
public class CacheKey {

    private String key;
    private Object[] params;

    public CacheKey(String key) {
        this(key, null);
    }

    public CacheKey(String key, Object... params) {
        if (StringUtils.isBlank(key)) {
            throw new IllegalArgumentException("key can not be empty");
        }
        this.key = key;
        this.params = params;
    }

    public String getKey() {
        StringBuilder result = new StringBuilder(key);
        if (ArrayUtils.isNotEmpty(params)) {
            for (Object param : params) {
                result.append("_").append(param);
            }
        }
        return result.toString();
    }

}
