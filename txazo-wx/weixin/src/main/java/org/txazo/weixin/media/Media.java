package org.txazo.weixin.media;

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

    private String type;
    private String file;

    public Media(MediaType mediaType, String file) {
        this.type = mediaType.getType();
        this.file = file;
    }

    public String getFile() {
        return file;
    }

    public String getType() {
        return type;
    }

}
