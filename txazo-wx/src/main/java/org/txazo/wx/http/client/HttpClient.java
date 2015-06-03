package org.txazo.wx.http.client;

import java.util.Map;

/**
 * HttpClient
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.06.2015
 */
public interface HttpClient {

    public String get(String url, Map<String, Object> params);

    public String post(String url, Map<String, Object> params);

    public String post(String url, Map<String, Object> params, String body);

}
