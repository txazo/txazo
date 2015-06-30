package org.txazo.weixin.http;

import org.apache.commons.lang3.StringUtils;
import org.txazo.weixin.annotation.EntityPath;
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
    private String domain = "https://qyapi.weixin.qq.com"; // 域名
    @EntityPath(path = "requests.request#uri")
    private String uri; // uri
    @EntityPath(path = "requests.request#requireParams")
    private String requireParams; // 必须参数
    @EntityPath(path = "requests.request#requestType")
    private String requestType = RequestType.GET.name(); // 请求类型
    @EntityPath(path = "requests.request#suffix")
    private String suffix; // 后缀

    public Request() {
    }

    public String getURL() {
        return domain + uri;
    }

    public String getDomain() {
        return domain;
    }

    public String getUri() {
        return uri;
    }

    public List<String> getRequireParams() {
        return StringUtils.isBlank(requireParams) ? (List<String>) Collections.EMPTY_LIST : Arrays.asList(requireParams.split(","));
    }

    public RequestType getRequestType() {
        return RequestType.valueOf(requestType);
    }

    public String getSuffix() {
        return suffix;
    }

}
