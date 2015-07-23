package org.txazo.weixin.http;

/**
 * HttpRequestException
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 08.06.2015
 */
public class HttpRequestException extends RuntimeException {

    private static final long serialVersionUID = 3315775071152928461L;

    public HttpRequestException() {
    }

    public HttpRequestException(Throwable cause) {
        super(cause);
    }

    public HttpRequestException(String message) {
        super(message);
    }

    public HttpRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
