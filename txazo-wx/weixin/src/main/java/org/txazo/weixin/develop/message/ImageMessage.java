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

    private static final long serialVersionUID = -6497578874816058464L;

    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public static class Image implements Serializable {

        private static final long serialVersionUID = -352429904232575299L;

        private String media_id;

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
