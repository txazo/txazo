package org.txazo.wx.http.client;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.txazo.wx.http.util.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * PoolHttpClient
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.06.2015
 */
public class PoolHttpClient implements HttpClient {

    public static final int DEFAULT_TIMEOUT_SECONDS = 5;

    private static PoolHttpClient instance;

    private CloseableHttpClient httpClient;
    private PoolingHttpClientConnectionManager connectionManager;
    private ExecutorService pool = Executors.newFixedThreadPool(50);

    private PoolHttpClient() {
        connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(200);
        connectionManager.setDefaultMaxPerRoute(20);
        httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
    }

    public static PoolHttpClient getInstance() {
        if (instance == null) {
            synchronized (PoolHttpClient.class) {
                if (instance == null) {
                    instance = new PoolHttpClient();
                }
            }
        }
        return instance;
    }

    @Override
    public String get(String url, Map<String, Object> params) {
        return executeHttp(new HttpGetCallable(url, params, httpClient));
    }

    @Override
    public String post(String url, Map<String, Object> params) {
        return executeHttp(new HttpPostCallable(url, params, null, httpClient));
    }

    @Override
    public String post(String url, Map<String, Object> params, String body) {
        return executeHttp(new HttpPostCallable(url, params, body, httpClient));
    }

    private String executeHttp(Callable<String> callable) {
        String result = null;
        Future<String> future = pool.submit(callable);
        try {
            result = future.get(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return result;
    }

    private abstract class HttpCallable implements Callable<String> {

        protected String url;
        protected Map<String, Object> params;
        protected CloseableHttpClient httpClient;

        public HttpCallable(final String url, final Map<String, Object> params, final CloseableHttpClient httpClient) {
            this.url = url;
            this.params = params;
            this.httpClient = httpClient;
        }

    }

    private class HttpGetCallable extends HttpCallable {

        public HttpGetCallable(final String url, final Map<String, Object> params, final CloseableHttpClient httpClient) {
            super(url, params, httpClient);
        }

        @Override
        public String call() {
            String result = null;
            CloseableHttpResponse response = null;
            HttpGet httpGet = new HttpGet(HttpUtils.getURL(url, params));
            try {
                response = httpClient.execute(httpGet);
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity);
                }
            } catch (IOException e) {
                IOUtils.closeQuietly(response);
            }
            return result;
        }
    }

    private class HttpPostCallable extends HttpCallable {

        private String body;

        public HttpPostCallable(final String url, final Map<String, Object> params, final String body, final CloseableHttpClient httpClient) {
            super(url, params, httpClient);
            this.body = body;
        }

        @Override
        public String call() {
            String result = null;
            CloseableHttpResponse response = null;
            HttpPost httpPost = new HttpPost(url);
            if (StringUtils.isNotBlank(body)) {
                httpPost = new HttpPost(HttpUtils.getURL(url, params));
                httpPost.setEntity(new StringEntity(body, Consts.UTF_8));
            } else if (MapUtils.isNotEmpty(params)) {
                httpPost = new HttpPost(url);
                String key = null;
                Object value = null;
                List<NameValuePair> formParams = new ArrayList<NameValuePair>();
                for (Iterator<String> i = params.keySet().iterator(); i.hasNext(); ) {
                    key = i.next();
                    value = params.get(key);
                    if (StringUtils.isBlank(key)) {
                        continue;
                    }
                    formParams.add(new BasicNameValuePair(key, value == null ? StringUtils.EMPTY : value.toString()));
                }
                if (CollectionUtils.isNotEmpty(formParams)) {
                    UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
                    httpPost.setEntity(formEntity);
                }
            }
            try {
                response = httpClient.execute(httpPost);
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity);
                }
            } catch (IOException e) {
                IOUtils.closeQuietly(response);
            }
            return result;
        }
    }

}
