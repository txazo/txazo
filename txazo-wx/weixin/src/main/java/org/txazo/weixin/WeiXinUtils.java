package org.txazo.weixin;

import org.junit.Test;
import org.txazo.log.LoggerUtils;
import org.txazo.weixin.develop.accesstoken.AccessTokenUtils;
import org.txazo.weixin.develop.agent.Agent;
import org.txazo.weixin.util.EnumUtils;
import org.txazo.weixin.develop.verify.VerifyUtils;

import java.io.File;

/**
 * WeiXinUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public class WeiXinUtils {

    /**
     * 创建应用菜单
     *
     * @param agentid
     * @param menu
     */
//    public static void createMenu(int agentid, String menu) {
//        String json = executor.executeRequest("/cgi-bin/menu/create", createParams("agentid", String.valueOf(agentid)), menu);
//        LoggerUtils.log(json);
//    }

//    @Test
//    public void testCreateMenu() {
//        String menu = "{\n" +
//                "  \"button\": [\n" +
//                "    {\n" +
//                "      \"type\": \"click\",\n" +
//                "      \"name\": \"今日歌2222\",\n" +
//                "      \"key\": \"V1001_TODAY_MUSIC\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"菜单\",\n" +
//                "      \"sub_button\": [\n" +
//                "        {\n" +
//                "          \"type\": \"view\",\n" +
//                "          \"name\": \"搜索\",\n" +
//                "          \"url\": \"http://www.soso.com/\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "          \"type\": \"click\",\n" +
//                "          \"name\": \"赞一下我们\",\n" +
//                "          \"key\": \"V1001_GOOD\"\n" +
//                "        }\n" +
//                "      ]\n" +
//                "    }\n" +
//                "  ]\n" +
//                "}";
//        WeiXinUtils.createMenu(3, menu);
//    }

//    @Test
//    public void test1() {
//        String json = executor.executeRequest("/cgi-bin/media/upload", createParams("type", "image"), "media", new File(this.getClass().getResource("/icon_4.jpg").getPath()));
//        LoggerUtils.log(json);
//    }

//    @Test
//    public void test2() {
//        String json = executor.executeRequest("/cgi-bin/media/get", createParams("media_id", "1GqqFaB8zS_2NeKRbHtgTsnifFDu-CwR0hDYow0Zm1nAzL-ELQQ-i6tgWHC9XBa6B"));
//        LoggerUtils.log(json);
//    }
//
//    public static void setAgent() {
//        executor.executeRequest("/cgi-bin/agent/set", EnumUtils.toJSONString(Agent.AGENT_0));
//        executor.executeRequest("/cgi-bin/agent/set", EnumUtils.toJSONString(Agent.AGENT_2));
//        executor.executeRequest("/cgi-bin/agent/set", EnumUtils.toJSONString(Agent.AGENT_3));
//        executor.executeRequest("/cgi-bin/agent/set", EnumUtils.toJSONString(Agent.AGENT_4));
//        executor.executeRequest("/cgi-bin/agent/set", EnumUtils.toJSONString(Agent.AGENT_5));
//        executor.executeRequest("/cgi-bin/agent/set", EnumUtils.toJSONString(Agent.AGENT_6));
//        executor.executeRequest("/cgi-bin/agent/set", EnumUtils.toJSONString(Agent.AGENT_7));
//        executor.executeRequest("/cgi-bin/agent/set", EnumUtils.toJSONString(Agent.AGENT_8));
//    }

//    @Test
//    public void test3() {
//        WeiXinUtils.setAgent();
//    }
    public static String verifyURL(String msg_signature, String timestamp, String nonce, String echostr) {
        return VerifyUtils.verifyURL(msg_signature, timestamp, nonce, echostr);
    }

    public static String getAccessToken() {
        return AccessTokenUtils.getAccessToken();
    }

}
