package org.txazo.wx.weixin;

import org.txazo.wx.http.client.HttpClient;
import org.txazo.wx.http.client.PoolHttpClient;
import org.txazo.wx.weixin.agent.Agent;

import java.util.List;

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
        return null;
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
