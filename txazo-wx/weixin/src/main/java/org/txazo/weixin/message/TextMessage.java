package org.txazo.weixin.message;

/**
 * TextMessage
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 09.06.2015
 */
public class TextMessage extends Message {

    private Text text;

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public class Text {

        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

    }

}
