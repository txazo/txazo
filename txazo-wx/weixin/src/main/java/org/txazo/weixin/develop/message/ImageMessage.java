package org.txazo.weixin.develop.message;

import java.io.Serializable;

/**
 * ImageMessage
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 09.06.2015
 */
public class ImageMessage extends Message {

    private static final long serialVersionUID = -1166214437756985122L;

    private Image image;

    public ImageMessage() {
        super("image");
    }

    public ImageMessage(String touser, String toparty, String totag, String agentid, String safe, Image image) {
        super(touser, toparty, totag, "image", agentid, safe);
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public static class Image implements Serializable {

        private static final long serialVersionUID = -1125915216446818173L;

        /** 图片media_id */
        private String media_id;

        public Image() {
        }

        public Image(String media_id) {
            this.media_id = media_id;
        }

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }

    }

}
