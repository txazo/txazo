package org.txazo.weixin;

import org.txazo.log.LoggerUtils;
import org.txazo.weixin.agent.Agent;
import org.txazo.weixin.bean.ContentType;
import org.txazo.weixin.bean.Request;
import org.txazo.weixin.holder.AccessTokenHolder;
import org.txazo.weixin.http.HttpClient;
import org.txazo.weixin.http.PoolHttpClient;
import org.txazo.weixin.util.EnumUtils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * WeiXinExecutor
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 04.06.2015
 */
public class WeiXinExecutor {

    private static final String WEI_XIN_DOMAIN = "https://qyapi.weixin.qq.com";

    private WeiXin weiXin = WeiXin.getInstance();
    private HttpClient httpClient = PoolHttpClient.getInstance();

    public String executeRequest(String uri) {
        return executeRequest(uri, null);
    }

    public String executeRequest(String uri, Map<String, Object> params) {
        return executeRequest(uri, params, null);
    }

    public String executeRequest(String uri, Map<String, Object> params, String body) {
        final Request request = weiXin.getRequest(uri);
        if (request == null) {
            LoggerUtils.log("executeRequest error uri: " + uri + " not exists");
            return null;
        }
        if (!checkRequireParams(request, params)) {
            return null;
        }
        if (params.containsKey("access_token")) {
            params.put("params", WeiXinUtils.getAccessToken());
        }
        String url = WEI_XIN_DOMAIN + request.getUri();
        ContentType contentType = request.getContentType();
        String response = null;
        switch (contentType) {
            case XML: {
                response = httpClient.post(url, params, body);
                break;
            }
            case JSON: {
                response = httpClient.post(url, params, body);
                break;
            }
            case STREAM: {
                response = httpClient.post(url, params, new File(body));
                break;
            }
            case DEFAULT: {
                response = httpClient.get(url, params);
                break;
            }
        }
        return response;
    }

    private boolean checkRequireParams(final Request request, Map<String, Object> params) {
        if (params == null) {
            return true;
        }
        for (String param : request.getRequireParams()) {
            if (!param.equals("access_token") && !params.containsKey(param)) {
                LoggerUtils.log("executeRequest error param: " + param + " is required in uri: " + request.getUri());
                return false;
            }
        }
        return true;
    }

    /**
     * 获取企业号应用
     *
     * @return
     */
    public Agent getAgent() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("access_token", "qWhQlZJxcDfyYcQ1WMtMK528qTSS05De_nXClXLSZ-DwsUYcCQr70XPCnDXMHEsz");
        // map.put("agentid", "0");
        String result = httpClient.post("https://qyapi.weixin.qq.com/cgi-bin/agent/set", map, EnumUtils.toJSONString(Agent.AGENT_0));
        LoggerUtils.log(result);
        return null;
    }

    public void main(String[] args) {
        getAgent();
    }

    /**
     * 设置企业号应用
     *
     * @param agent
     */
    public void setAgent(Agent agent) {
    }

    /**
     * 获取企业号应用列表
     *
     * @return
     */
    public List<Agent> listAgent() {
        return null;
    }

}
