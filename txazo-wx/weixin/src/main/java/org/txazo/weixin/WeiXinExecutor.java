package org.txazo.weixin;

import org.txazo.weixin.http.*;

import java.io.File;
import java.util.Map;

/**
 * WeiXinExecutor
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 04.06.2015
 */
public class WeiXinExecutor {

    private WeiXin weiXin = WeiXin.getInstance();
    private HttpRequestHandler requestHandler = new DefaultHttpRequestHandler();

    public String executeRequest(String uri) {
        return requestHandler.handle(weiXin.getRequest(uri)).getContent();
    }

    public String executeRequest(String uri, String body) {
        return requestHandler.handle(weiXin.getRequest(uri), body).getContent();
    }

    public String executeRequest(String uri, String key, File file) {
        return requestHandler.handle(weiXin.getRequest(uri), key, file).getContent();
    }

    public String executeRequest(String uri, Map<String, Object> params) {
        return requestHandler.handle(weiXin.getRequest(uri), params).getContent();
    }

    public String executeRequest(String uri, Map<String, Object> params, String body) {
        return requestHandler.handle(weiXin.getRequest(uri), params, body).getContent();
    }

    public String executeRequest(String uri, Map<String, Object> params, String key, File file) {
        return requestHandler.handle(weiXin.getRequest(uri), params, key, file).getContent();
    }

}
