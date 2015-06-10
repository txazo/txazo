package org.txazo.weixin.develop.message;

import java.io.Serializable;

/**
 * TextMessage
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 09.06.2015
 */
public class TextMessage extends Message {

    private static final long serialVersionUID = -5286782242685748633L;

    private Text text;

    public TextMessage() {
        super("text");
    }

    public TextMessage(String touser, String toparty, String totag, String agentid, String safe, Text text) {
        super(touser, toparty, totag, "text", agentid, safe);
        this.text = text;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public static class Text implements Serializable {

        private static final long serialVersionUID = -5479304718949081585L;

        /** 消息内容 */
        private String content;

        public Text() {
        }

        public Text(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

    }

}
