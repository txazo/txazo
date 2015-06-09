package org.txazo.weixin.http;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.message.BasicNameValuePair;
import org.txazo.weixin.WeiXinUtils;

import java.io.File;
import java.util.*;

/**
 * DefaultHttpRequestHandler
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 08.06.2015
 */
public class DefaultHttpRequestHandler implements HttpRequestHandler {

    private HttpClient httpClient = PoolHttpClient.getInstance();

    @Override
    public Response handle(Request request) {
        return handle(request, null, null, null, null);
    }

    @Override
    public Response handle(Request request, String body) {
        return handle(request, null, body, null, null);
    }

    @Override
    public Response handle(Request request, String key, File file) {
        return handle(request, null, null, key, file);
    }

    @Override
    public Response handle(Request request, Map<String, Object> params) {
        return handle(request, params, null, null, null);
    }

    @Override
    public Response handle(Request request, Map<String, Object> params, String body) {
        return handle(request, params, body, null, null);
    }

    @Override
    public Response handle(Request request, Map<String, Object> params, String key, File file) {
        return handle(request, params, null, key, file);
    }

    private Response handle(Request request, Map<String, Object> params, String body, String key, File file) {
        if (request == null) {
            return new Response(Response.ERROR, "request must not be null");
        }
        params = (params == null) ? new HashMap<String, Object>() : params;
        if (!checkRequireParams(request, params)) {
            return new Response(Response.ERROR, "required parameter is missing");
        }
        if (request.getRequireParams().contains("access_token")) {
            params.put("access_token", WeiXinUtils.getAccessToken());
        }

        Response response = null;
        try {
            String result = httpClient.process(getHttpRequest(request, params, body, key, file));
            return new Response(result, Response.SUCC);
        } catch (Throwable t) {
            return new Response(Response.FAIL, t.getMessage());
        }
    }

    private boolean checkRequireParams(final Request request, final Map<String, Object> params) {
        if (params == null) {
            return true;
        }
        for (String param : request.getRequireParams()) {
            if (!param.equals("access_token") && !params.containsKey(param)) {
                return false;
            }
        }
        return true;
    }

    private HttpRequestBase getHttpRequest(Request request, Map<String, Object> params, String body, String key, File file) {
        HttpRequestBase httpRequest = null;
        switch (request.getRequestType()) {
            case GET: {
                httpRequest = new HttpGet(HttpUtils.getURL(request, params));
                break;
            }
            case POST_FORM: {
                HttpPost httpPost = new HttpPost(request.getURL());
                httpPost.setEntity(getFormEntity(params));
                httpRequest = httpPost;
                break;
            }
            case POST_TEXT: {
                HttpPost httpPost = new HttpPost(HttpUtils.getURL(request, params));
                httpPost.setEntity(new StringEntity(body, Consts.UTF_8));
                httpRequest = httpPost;
                break;
            }
            case POST_FILE: {
                HttpPost httpPost = new HttpPost(HttpUtils.getURL(request, params));
                HttpEntity httpEntity = MultipartEntityBuilder.create()
                        .addPart(key, new FileBody(file))
                        .build();
                httpPost.setEntity(httpEntity);
                httpRequest = httpPost;
                break;
            }
        }
        return httpRequest;
    }

    private HttpEntity getFormEntity(Map<String, Object> params) {
        List<NameValuePair> formParams = new ArrayList<NameValuePair>();
        if (MapUtils.isNotEmpty(params)) {
            Map.Entry<String, Object> entry = null;
            for (Iterator<Map.Entry<String, Object>> i = params.entrySet().iterator(); i.hasNext(); ) {
                entry = i.next();
                if (StringUtils.isBlank(entry.getKey())) {
                    continue;
                }
                formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue() == null ? StringUtils.EMPTY : entry.getValue().toString()));
            }
        }
        return new UrlEncodedFormEntity(formParams, Consts.UTF_8);
    }

}
