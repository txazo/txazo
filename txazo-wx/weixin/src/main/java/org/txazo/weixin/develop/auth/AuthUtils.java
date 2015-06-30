package org.txazo.weixin.develop.auth;

import org.txazo.weixin.WeiXinHolder;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * WeiXin
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 30.06.2015
 */
public abstract class AuthUtils extends WeiXinHolder {

    private static final String REDIRECT_URL = "https://open.weixin.qq.com/connect/oauth2/authorize";

    public static void redirectToAuth(String redirectUrl, String state, HttpServletResponse response) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(REDIRECT_URL).append("?");
        sb.append("appid=").append(weiXin.getCrop().getCorpid());
        sb.append("&redirect_uri=").append(URLEncoder.encode(redirectUrl, "UTF-8"));
        sb.append("&response_type=code");
        sb.append("&scope=snsapi_base");
        sb.append("&state=").append(state);
        sb.append("#wechat_redirect");
        response.sendRedirect(sb.toString());
    }

}
