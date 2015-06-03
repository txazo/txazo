package org.txazo.wx.http.util;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Iterator;
import java.util.Map;

/**
 * HttpUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.06.2015
 */
public abstract class HttpUtils {

    public static String getURL(String url, Map<String, Object> params) {
        String paramsString = getParamsString(params);
        return StringUtils.isBlank(paramsString) ? url : url + "?" + paramsString;
    }

    public static String getParamsString(Map<String, Object> params) {
        if (MapUtils.isEmpty(params)) {
            return null;
        }

        String key = null;
        StringBuilder sb = new StringBuilder();
        for (Iterator<String> i = params.keySet().iterator(); i.hasNext(); ) {
            key = i.next();
            if (StringUtils.isBlank(key)) {
                continue;
            }
            sb.append(key).append("=").append(params.get(key)).append("&");
        }

        String paramsString = sb.toString();
        return StringUtils.isBlank(paramsString) ? null : paramsString.substring(0, paramsString.length() - 1);
    }

}
