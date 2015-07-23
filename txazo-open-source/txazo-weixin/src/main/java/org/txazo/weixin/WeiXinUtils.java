package org.txazo.weixin;

import org.txazo.weixin.develop.accesstoken.AccessTokenUtils;
import org.txazo.weixin.develop.auth.AuthUtils;
import org.txazo.weixin.develop.jsapi.JsApiUtils;
import org.txazo.weixin.develop.jsapi.JsConfig;
import org.txazo.weixin.develop.media.MediaUtils;
import org.txazo.weixin.develop.message.Message;
import org.txazo.weixin.develop.message.MessageUtils;
import org.txazo.weixin.develop.verify.VerifyUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    public static String sendMessage(Message message) {
        return MessageUtils.sendMessage(message);
    }

    public static void redirectToAuth(String redirectUrl, String state, HttpServletResponse response) throws IOException {
        AuthUtils.redirectToAuth(redirectUrl, state, response);
    }

    public static String getUserId(String code) {
        return AuthUtils.getUserId(code);
    }

    public static JsConfig generateJsConfig(String url) {
        return JsApiUtils.generateJsConfig(url);
    }

}
