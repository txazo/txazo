package org.txazo.weixin.develop.message;

import com.alibaba.fastjson.JSON;
import org.txazo.weixin.WeiXinHolder;

/**
 * MessageUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 09.06.2015
 */
public abstract class MessageUtils extends WeiXinHolder {

    public static String sendMessage(Message message) {
        return executor.executeRequest(URI_MESSAGE_SEND, JSON.toJSONString(message));
    }

}
