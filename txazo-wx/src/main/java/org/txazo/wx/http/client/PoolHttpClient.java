package org.txazo.wx.http.client;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.txazo.wx.http.util.HttpUtils;

import java.io.IOException;
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
        String result = null;
        Future<String> future = pool.submit(new HttpGetCallable(url, params, httpClient));
        try {
            result = future.get(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String post(String url, Map<String, Object> params) {
        String result = null;
        Future<String> future = pool.submit(new HttpPostCallable(url, params, httpClient));
        try {
            result = future.get(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
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
            try {
                HttpGet httpGet = new HttpGet(HttpUtils.getURL(url, params));
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

        public HttpPostCallable(final String url, final Map<String, Object> params, final CloseableHttpClient httpClient) {
            super(url, params, httpClient);
        }

        @Override
        public String call() throws Exception {
            return null;
        }
    }

}
