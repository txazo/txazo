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

    private static final long serialVersionUID = -7039732560673428855L;

    private Text text;

    public TextMessage() {
    }

    public TextMessage(String touser, String toparty, String totag, String msgtype, String agentid, String safe, Text text) {
        super(touser, toparty, totag, msgtype, agentid, safe);
        this.text = text;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public static class Text implements Serializable {

        private static final long serialVersionUID = 8449831999138239975L;

        private String content;

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
