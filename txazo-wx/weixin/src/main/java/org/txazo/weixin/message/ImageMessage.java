package org.txazo.weixin.message;

/**
 * ImageMessage
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 09.06.2015
 */
public class ImageMessage extends Message {

    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public class Image {

        private String media_id;

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String media_id) {
            this.media_id = media_id;
        }

    }

}
