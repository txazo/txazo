package org.txazo.weixin.http;

import org.apache.http.client.methods.HttpRequestBase;

/**
 * HttpClient
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.06.2015
 */
public interface HttpClient {

    String process(HttpRequestBase httpRequest);

}
