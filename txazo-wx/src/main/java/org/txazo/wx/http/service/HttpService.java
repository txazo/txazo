package org.txazo.wx.http.service;

import org.springframework.stereotype.Service;
import org.txazo.wx.http.client.HttpClient;
import org.txazo.wx.http.client.PoolHttpClient;

import java.util.Map;

/**
 * HttpService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.06.2015
 */
@Service
public class HttpService {

    private HttpClient httpClient;

    public HttpService() {
        httpClient = PoolHttpClient.getInstance();
    }

    public String get(String url, Map<String, Object> params) {
        return httpClient.get(url, params);
    }

    public String post(String url, Map<String, Object> params) {
        return httpClient.post(url, params);
    }

    public String post(String url, Map<String, Object> params, String body) {
        return httpClient.post(url, params, body);
    }

}
