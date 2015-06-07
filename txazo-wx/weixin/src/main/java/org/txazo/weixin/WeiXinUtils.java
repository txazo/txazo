package org.txazo.weixin;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.ArrayUtils;
import org.txazo.log.LoggerUtils;
import org.txazo.weixin.bean.AccessToken;
import org.txazo.weixin.bean.Crop;

import java.util.HashMap;
import java.util.Map;

/**
 * WeiXinUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public abstract class WeiXinUtils {

    private static WeiXin weiXin = WeiXin.getInstance();
    private static WeiXinExecutor executor = new WeiXinExecutor();

    private static Map<String, Object> createParams(String... params) {
        if (ArrayUtils.isEmpty(params)) {
            return null;
        }
        Map<String, Object> paramMap = new HashMap<String, Object>();
        for (int i = 0; i < params.length; i += 2) {
            paramMap.put(params[i], i == params.length - 1 ? null : params[i + 1]);
        }
        return paramMap;
    }

    public static AccessToken getAccessToken() {
        Crop crop = weiXin.getCrop();
        String json = executor.executeRequest("/cgi-bin/gettoken", createParams("corpid", crop.getCorpid(), "corpsecret", crop.getCorpsecret()));
        AccessToken accessToken = null;
        try {
            accessToken = JSON.parseObject(json, AccessToken.class);
        } catch (Exception e) {
            LoggerUtils.log("getAccessToken failed", e);
        }
        return accessToken;
    }

}
