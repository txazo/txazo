package org.txazo.util.collection.map;

import org.apache.commons.lang3.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * MapUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.07.2015
 */
public abstract class MapUtils {

    public static Map<Object, Object> buildMap(Object... keyValuePairs) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        if (ArrayUtils.isNotEmpty(keyValuePairs)) {
            for (int i = 0; i < keyValuePairs.length; i += 2) {
                map.put(keyValuePairs[i], i == keyValuePairs.length - 1 ? null : keyValuePairs[i + 1]);
            }
        }
        return map;
    }

}
