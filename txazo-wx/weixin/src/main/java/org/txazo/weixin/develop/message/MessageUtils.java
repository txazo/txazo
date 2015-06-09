package org.txazo.weixin.develop.message;

import com.alibaba.fastjson.JSON;
import org.txazo.log.LoggerUtils;
import org.txazo.weixin.WeiXinHolder;

/**
 * MessageUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 09.06.2015
 */
public abstract class MessageUtils extends WeiXinHolder {

    private static void sendMessage(Message message) {
        String result = executor.executeRequest("/cgi-bin/message/send", JSON.toJSONString(message));
        LoggerUtils.log(result);
    }

    public static void sendTextMessage(TextMessage message) {
        sendMessage(message);
    }

    public static void sendImageMessage(ImageMessage message) {
        sendMessage(message);
    }

    public static void main(String[] args) {
        MessageUtils.sendTextMessage(new TextMessage("txazo1218", null, null, "text", "2", "0", new TextMessage.Text("hello")));
    }

}
