package org.txazo.weixin;

import org.txazo.weixin.develop.accesstoken.AccessTokenUtils;
import org.txazo.weixin.develop.media.MediaUtils;
import org.txazo.weixin.develop.verify.VerifyUtils;

/**
 * WeiXinUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public abstract class WeiXinUtils {

    public static String getAccessToken() {
        return AccessTokenUtils.getAccessToken();
    }

    public static String getMediaId(String path) {
        return MediaUtils.getMediaId(path);
    }

    public static String verifyURL(String msg_signature, String timestamp, String nonce, String echostr) {
        return VerifyUtils.verifyURL(msg_signature, timestamp, nonce, echostr);
    }

}
