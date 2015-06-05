package org.txazo.weixin;

import org.txazo.log.LoggerUtils;
import org.txazo.weixin.agent.Agent;
import org.txazo.weixin.holder.AccessTokenHolder;
import org.txazo.weixin.http.HttpClient;
import org.txazo.weixin.http.PoolHttpClient;
import org.txazo.weixin.util.EnumUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * WeiXinUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 04.06.2015
 */
public class WeiXinHandler {

    private WeiXin weiXin;
    private AccessTokenHolder tokenHolder = AccessTokenHolder.getInstance();
    private HttpClient httpClient = PoolHttpClient.getInstance();

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
