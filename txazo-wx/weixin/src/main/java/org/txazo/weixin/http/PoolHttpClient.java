package org.txazo.weixin.http;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.txazo.weixin.http.ssl.SSLManager;

import java.io.IOException;
import java.util.*;
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

    private final CloseableHttpClient httpClient;
    private final PoolingHttpClientConnectionManager connectionManager;
    private final ExecutorService pool = Executors.newFixedThreadPool(50);
    private final ResponseHandler<String> responseHandler = new DefaultResponseHandler();

    private PoolHttpClient() {
        connectionManager = new PoolingHttpClientConnectionManager(getSocketFactoryRegistry());
        connectionManager.setMaxTotal(200);
        connectionManager.setDefaultMaxPerRoute(20);
        httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(getRequestConfig())
                .setRetryHandler(new DefaultHttpRequestRetryHandler())
                .setSSLSocketFactory(SSLManager.buildSSLSocketFactory())
                .build();
    }

    protected Registry<ConnectionSocketFactory> getSocketFactoryRegistry() {
        return RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.INSTANCE)
                .register("https", new SSLConnectionSocketFactory(SSLContexts.createSystemDefault()))
                .build();
    }

    protected RequestConfig getRequestConfig() {
        return RequestConfig.custom()
                .setCookieSpec(CookieSpecs.DEFAULT)
                .setExpectContinueEnabled(true)
                .setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
                .setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC))
                .setSocketTimeout(5000)
                .setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .build();
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
    public String process(HttpRequestBase httpRequest) {
        return executeHttp(new HttpReuqestCallable(httpRequest, httpClient));
    }

    private String executeHttp(Callable<String> callable) {
        String result = null;
        Future<String> future = pool.submit(callable);
        try {
            result = future.get(DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        } catch (Throwable t) {
            throw new HttpRequestException(t);
        }
        return result;
    }

    private class HttpReuqestCallable implements Callable<String> {

        private HttpRequestBase request;
        protected CloseableHttpClient httpClient;

        public HttpReuqestCallable(final HttpRequestBase request, final CloseableHttpClient httpClient) {
            this.request = request;
            this.httpClient = httpClient;
        }

        @Override
        public String call() throws IOException {
            String result = null;
            CloseableHttpResponse response = null;
            try {
                result = httpClient.execute(request, responseHandler);
            } finally {
                IOUtils.closeQuietly(response);
            }
            return result;
        }

    }

}
