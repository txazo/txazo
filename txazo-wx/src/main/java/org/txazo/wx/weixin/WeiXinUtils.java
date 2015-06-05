package org.txazo.wx.weixin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.txazo.log.LoggerUtils;
import org.txazo.wx.http.client.HttpClient;
import org.txazo.wx.http.client.PoolHttpClient;
import org.txazo.wx.weixin.agent.Agent;
import org.txazo.wx.weixin.media.MediaType;
import org.txazo.wx.weixin.util.EnumUtils;

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
public abstract class WeiXinUtils {

    private static HttpClient httpClient = PoolHttpClient.getInstance();

    /**
     * 获取企业号应用
     *
     * @return
     */
    public static Agent getAgent() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("access_token", "qWhQlZJxcDfyYcQ1WMtMK528qTSS05De_nXClXLSZ-DwsUYcCQr70XPCnDXMHEsz");
        // map.put("agentid", "0");
        String result = httpClient.post("https://qyapi.weixin.qq.com/cgi-bin/agent/set", map, EnumUtils.toJSONString(Agent.AGENT_0));
        LoggerUtils.log(result);
        return null;
    }

    public static void main(String[] args) {
        getAgent();
    }

    /**
     * 设置企业号应用
     *
     * @param agent
     */
    public static void setAgent(Agent agent) {
    }

    /**
     * 获取企业号应用列表
     *
     * @return
     */
    public static List<Agent> listAgent() {
        return null;
    }

}
