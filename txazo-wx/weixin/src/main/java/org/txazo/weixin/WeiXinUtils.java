package org.txazo.weixin;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.txazo.log.LoggerUtils;
import org.txazo.weixin.agent.Agent;
import org.txazo.weixin.bean.AccessToken;
import org.txazo.weixin.bean.Crop;
import org.txazo.weixin.util.EnumUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * WeiXinUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public class WeiXinUtils {

    private static WeiXin weiXin = WeiXin.getInstance();
    private static WeiXinExecutor executor = WeiXinExecutor.getInstance();

    private static Map<String, Object> createParams(String... params) {
        if (ArrayUtils.isEmpty(params)) {
            return null;
        }
        Map<String, Object> paramMap = new HashMap<String, Object>();
        for (int i = 0; i < params.length; i += 2) {
            paramMap.put(params[i], i == params.length - 1 ? null : params[i + 1]);
        }
        return paramMap;
    }

    public static AccessToken getAccessToken() {
        Crop crop = weiXin.getCrop();
        String json = executor.executeRequest("/cgi-bin/gettoken", createParams("corpid", crop.getCorpid(), "corpsecret", crop.getCorpsecret()));
        AccessToken accessToken = null;
        try {
            accessToken = JSON.parseObject(json, AccessToken.class);
        } catch (Exception e) {
            LoggerUtils.log("getAccessToken failed", e);
        }
        return accessToken;
    }

    /**
     * 创建应用菜单
     *
     * @param agentid
     * @param menu
     */
    public static void createMenu(int agentid, String menu) {
        String json = executor.executeRequest("/cgi-bin/menu/create", createParams("agentid", String.valueOf(agentid)), menu);
        LoggerUtils.log(json);
    }

    @Test
    public void testCreateMenu() {
        String menu = "{\n" +
                "  \"button\": [\n" +
                "    {\n" +
                "      \"type\": \"click\",\n" +
                "      \"name\": \"今日歌2222\",\n" +
                "      \"key\": \"V1001_TODAY_MUSIC\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"菜单\",\n" +
                "      \"sub_button\": [\n" +
                "        {\n" +
                "          \"type\": \"view\",\n" +
                "          \"name\": \"搜索\",\n" +
                "          \"url\": \"http://www.soso.com/\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"type\": \"click\",\n" +
                "          \"name\": \"赞一下我们\",\n" +
                "          \"key\": \"V1001_GOOD\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        WeiXinUtils.createMenu(3, menu);
    }

    @Test
    public void test1() {
        String json = executor.executeRequest("/cgi-bin/media/upload", createParams("type", "image"), "media", new File(this.getClass().getResource("/icon_4.jpg").getPath()));
        LoggerUtils.log(json);
    }

    @Test
    public void test2() {
        String json = executor.executeRequest("/cgi-bin/media/get", createParams("media_id", "1GqqFaB8zS_2NeKRbHtgTsnifFDu-CwR0hDYow0Zm1nAzL-ELQQ-i6tgWHC9XBa6B"));
        LoggerUtils.log(json);
    }

    public static void setAgent() {
        LoggerUtils.log(EnumUtils.toJSONString(Agent.AGENT_2));
        String json = executor.executeRequest("/cgi-bin/agent/set", EnumUtils.toJSONString(Agent.AGENT_4));
        LoggerUtils.log(json);
    }

    @Test
    public void test3() {
        WeiXinUtils.setAgent();
    }

}
