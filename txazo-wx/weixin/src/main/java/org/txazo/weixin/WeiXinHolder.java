package org.txazo.weixin;

import org.apache.commons.lang3.ArrayUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * WeiXinHolder
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 09.06.2015
 */
public abstract class WeiXinHolder {

    protected static WeiXin weiXin = WeiXin.getInstance();
    protected static WeiXinExecutor executor = WeiXinExecutor.getInstance();

    protected static Map<String, Object> createParams(String... params) {
        if (ArrayUtils.isEmpty(params)) {
            return null;
        }
        Map<String, Object> paramMap = new HashMap<String, Object>();
        for (int i = 0; i < params.length; i += 2) {
            paramMap.put(params[i], i == params.length - 1 ? null : params[i + 1]);
        }
        return paramMap;
    }

}
