package org.txazo.weixin.bean;

import org.apache.commons.lang3.StringUtils;
import org.txazo.weixin.enums.EntityPath;
import org.txazo.weixin.xml.XmlEntity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Request
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
@EntityPath(path = "requests.request")
public class Request implements XmlEntity {

    @EntityPath(path = "requests.request#domain")
    private String domain;
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

    public List<String> getRequireParams() {
        return StringUtils.isBlank(requireParams) ? (List<String>) Collections.EMPTY_LIST : Arrays.asList(requireParams.split(","));
    }

    public ContentType getContentType() {
        return ContentType.valueOf(contentType);
    }

}
