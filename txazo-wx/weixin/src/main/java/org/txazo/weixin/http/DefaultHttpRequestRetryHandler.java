package org.txazo.weixin.http;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.protocol.HttpContext;
import org.txazo.log.LoggerUtils;

import javax.net.ssl.SSLException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

/**
 * DefaultHttpRequestRetryHandler
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public class DefaultHttpRequestRetryHandler implements HttpRequestRetryHandler {

    private static final int MAX_RETRY_COUNT = 3;

    @Override
    public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
        if (executionCount >= MAX_RETRY_COUNT) {
            return false;
        }
        if (exception instanceof InterruptedIOException) {
            return false;
        }
        if (exception instanceof UnknownHostException) {
            return false;
        }
        if (exception instanceof ConnectTimeoutException) {
            return false;
        }
        if (exception instanceof SSLException) {
            return false;
        }
        LoggerUtils.log("retryRequest failed", exception);
        HttpClientContext clientContext = HttpClientContext.adapt(context);
        HttpRequest request = clientContext.getRequest();
        return !(request instanceof HttpEntityEnclosingRequest);
    }

}
