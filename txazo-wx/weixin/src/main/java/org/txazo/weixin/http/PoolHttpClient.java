package org.txazo.weixin.http;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.txazo.log.LoggerUtils;
import org.txazo.weixin.http.ssl.SSLManager;
import org.txazo.weixin.http.util.HttpUtils;

import java.io.File;
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

    private CloseableHttpClient httpClient;
    private PoolingHttpClientConnectionManager connectionManager;
    private ExecutorService pool = Executors.newFixedThreadPool(50);
    private ResponseHandler<String> responseHandler = new DefaultResponseHandler();

    private PoolHttpClient() {
        connectionManager = new PoolingHttpClientConnectionManager(getSocketFactoryRegistry());
        connectionManager.setMaxTotal(200);
        connectionManager.setDefaultMaxPerRoute(20);
        httpClient = HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(this.getRequestConfig())
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
    public String get(String url, Map<String, Object> params) {
        return executeHttp(new HttpReuqestCallable(url, params, httpClient, HttpRequestType.REQUEST));
    }

    @Override
    public String post(String url, Map<String, Object> params) {
        return executeHttp(new HttpReuqestCallable(url, params, httpClient, HttpRequestType.POST_SIMPLE));
    }

    @Override
    public String post(String url, Map<String, Object> params, String content) {
        return executeHttp(new HttpReuqestCallable(url, params, content, httpClient, HttpRequestType.POST_STRING));
    }

    @Override
    public String post(String url, Map<String, Object> params, File file) {
        return executeHttp(new HttpReuqestCallable(url, params, file, httpClient, HttpRequestType.POST_IMAGE));
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

    private enum HttpRequestType {

        REQUEST, POST_SIMPLE, POST_STRING, POST_IMAGE

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
            } else {

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

    private class HttpReuqestCallable implements Callable<String> {

        private String url;
        private Map<String, Object> params;
        private String content;
        private File file;
        private CloseableHttpClient httpClient;
        private HttpRequestType requestType;

        public HttpReuqestCallable(String url, Map<String, Object> params, CloseableHttpClient httpClient, HttpRequestType requestType) {
            this(url, params, null, null, httpClient, requestType);
        }

        public HttpReuqestCallable(String url, Map<String, Object> params, String content, CloseableHttpClient httpClient, HttpRequestType requestType) {
            this(url, params, content, null, httpClient, requestType);
        }

        public HttpReuqestCallable(String url, Map<String, Object> params, File file, CloseableHttpClient httpClient, HttpRequestType requestType) {
            this(url, params, null, file, httpClient, requestType);
        }

        public HttpReuqestCallable(String url, Map<String, Object> params, String content, File file, CloseableHttpClient httpClient, HttpRequestType requestType) {
            this.url = url;
            this.params = params;
            this.content = content;
            this.file = file;
            this.httpClient = httpClient;
            this.requestType = requestType;
        }

        @Override
        public String call() {
            String result = null;
            HttpRequestBase request = null;
            CloseableHttpResponse response = null;

            switch (requestType) {
                case REQUEST: {
                    request = new HttpGet(HttpUtils.getURL(url, params));
                    break;
                }
                case POST_SIMPLE: {
                    HttpPost httpPost = new HttpPost(url);
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
                    request = httpPost;
                    break;
                }
                case POST_STRING: {
                    HttpPost httpPost = new HttpPost(HttpUtils.getURL(url, params));
                    httpPost.setEntity(new StringEntity(content, Consts.UTF_8));
                    request = httpPost;
                    break;
                }
                case POST_IMAGE: {
                    HttpPost httpPost = new HttpPost(HttpUtils.getURL(url, params));
                    HttpEntity httpEntity = MultipartEntityBuilder.create()
                            .addPart("media", new FileBody(file))
                            .build();
                    httpPost.setEntity(httpEntity);
                    request = httpPost;
                    break;
                }
            }

            try {
                result = httpClient.execute(request, responseHandler);
            } catch (IOException e) {
                LoggerUtils.log("HttpClient request failed", e);
            } finally {
                IOUtils.closeQuietly(response);
            }
            return result;
        }
    }

}
