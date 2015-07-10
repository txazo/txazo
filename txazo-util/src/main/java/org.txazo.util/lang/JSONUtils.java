package org.txazo.util.lang;

import com.alibaba.fastjson.JSONArray;
import org.txazo.util.collection.map.MapUtils;

/**
 * JSON工具类
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.07.2015
 */
public abstract class JSONUtils {

    public static String buildJSONString(Object... keyValuePairs) {
        return JSONArray.toJSONString(MapUtils.buildMap(keyValuePairs));
    }

}
