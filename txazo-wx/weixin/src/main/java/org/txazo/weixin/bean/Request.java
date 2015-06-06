package org.txazo.weixin.bean;

import org.txazo.weixin.enums.EntityPath;
import org.txazo.weixin.xml.XmlEntity;

/**
 * Request
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
@EntityPath(path = "requests.request")
public class Request implements XmlEntity {

    @EntityPath(path = "requests.request#uri")
    private String uri;
    @EntityPath(path = "requests.request#requireParams")
    private String requireParams;
    @EntityPath(path = "requests.request#contentType")
    private String contentType;

    public Request() {
    }

    public String getUri() {
        return uri;
    }

    public String getRequireParams() {
        return requireParams;
    }

    public ContentType getContentType() {
        return ContentType.valueOf(contentType);
    }

}
