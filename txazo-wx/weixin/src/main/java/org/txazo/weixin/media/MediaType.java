package org.txazo.weixin.media;

/**
 * MediaType
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public enum MediaType {

    IMAGE("image"),
    VOICE("voice"),
    VIDEO("video"),
    FILE("file");

    private String type;

    MediaType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
