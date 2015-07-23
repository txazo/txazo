package org.txazo.weixin.http;

import java.io.File;
import java.util.Map;

/**
 * HttpRequestHandler
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 08.06.2015
 */
public interface HttpRequestHandler {

    Response handle(Request request);

    Response handle(Request request, String body);

    Response handle(Request request, String key, File file);

    Response handle(Request request, Map<String, Object> params);

    Response handle(Request request, Map<String, Object> params, String body);

    Response handle(Request request, Map<String, Object> params, String key, File file);

}
