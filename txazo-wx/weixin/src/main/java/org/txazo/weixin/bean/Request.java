package org.txazo.weixin.bean;

import java.io.Serializable;

/**
 * Request
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public class Request implements XmlBean, Serializable {

    private static final long serialVersionUID = -8735999882685588711L;

    private String uri;
    private String requireParams;
    private ContentType contentType;

    Request(String uri, String params, ContentType contentType) {
        this.uri = uri;
        this.requireParams = params;
        this.contentType = contentType;
    }

}
