package org.txazo.weixin.message;

/**
 * MessageUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 09.06.2015
 */
public abstract class MessageUtils {

    private static void sendMessage(Message message) {

    }

    public static void sendTextMessage(TextMessage message) {
        sendMessage(message);
    }

    public static void sendImageMessage(ImageMessage message) {
        sendMessage(message);
    }

}
