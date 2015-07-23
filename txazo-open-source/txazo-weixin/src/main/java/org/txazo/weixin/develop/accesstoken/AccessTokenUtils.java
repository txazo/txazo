package org.txazo.weixin.develop.accesstoken;

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

    static AccessToken requestAccessToken() {
        Crop crop = weiXin.getCrop();
        String json = executor.executeRequest(URI_GET_TOKEN, createParams("corpid", crop.getCorpid(), "corpsecret", crop.getCorpsecret()));
        return parseResult(json, AccessToken.class);
    }

}
