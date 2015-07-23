package org.txazo.weixin.develop.media;

import java.io.Serializable;

/**
 * Media
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public class Media implements Serializable {

    private static final long serialVersionUID = -6619063245708445972L;

    /** media_id有效时间(2天23小时50分钟) */
    private static final long MEDIA_ID_VALID_TIME = (3 * 24 * 60 - 10) * 60 * 1000;

    /** 媒体文件路径 */
    private String path;
    /** 媒体文件hash */
    private String hash;
    /** 媒体文件类型 */
    private String type;
    /** 媒体文件唯一标识 */
    private String media_id;
    /** 媒体文件上传时间戳 */
    private long created_at;

    public Media() {
    }

    public Media(String path, MediaType mediaType) {
        this.path = path;
        this.type = mediaType.getType();
    }

    public boolean isVaild() {
        return (System.currentTimeMillis() - created_at) <= MEDIA_ID_VALID_TIME;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

}
