package org.txazo.weixin.develop.accesstoken;

import com.alibaba.fastjson.JSON;
import org.txazo.weixin.WeiXinHolder;
import org.txazo.weixin.bean.Crop;

/**
 * AccessTokenUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 09.06.2015
 */
public abstract class AccessTokenUtils extends WeiXinHolder {

    private static AccessTokenHolder accessTokenHolder = AccessTokenHolder.getInstance();

    public static String getAccessToken() {
        return accessTokenHolder.getAccessToken();
    }

    protected static AccessToken requestAccessToken() {
        Crop crop = weiXin.getCrop();
        String json = executor.executeRequest("/cgi-bin/gettoken", createParams("corpid", crop.getCorpid(), "corpsecret", crop.getCorpsecret()));
        AccessToken accessToken = null;
        try {
            accessToken = JSON.parseObject(json, AccessToken.class);
        } catch (Exception e) {
        }
        return accessToken;
    }

}
