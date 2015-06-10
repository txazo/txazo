package org.txazo.weixin;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.ArrayUtils;
import org.txazo.weixin.resource.DefaultResourceLoader;
import org.txazo.weixin.resource.ResourceLoader;

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

    protected static final String URI_GET_TOKEN = "/cgi-bin/gettoken";

    protected static WeiXin weiXin = WeiXin.getInstance();
    protected static WeiXinExecutor executor = WeiXinExecutor.getInstance();
    protected static ResourceLoader resourceLoader = new DefaultResourceLoader();

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

    protected static <T> T parseResult(String json, Class<T> clazz) {
        try {
            return JSON.parseObject(json, clazz);
        } catch (Exception e) {
            return null;
        }
    }

}
