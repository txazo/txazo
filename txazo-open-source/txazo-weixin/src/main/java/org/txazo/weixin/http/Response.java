package org.txazo.weixin.http;

/**
 * Response
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 08.06.2015
 */
public class Response {

    public static final int SUCC = 1;
    public static final int FAIL = 2;
    public static final int ERROR = 3;

    private int status;
    private String msg;
    private String content;

    public Response(int status) {
        this(null, status, null);
    }

    public Response(int status, String msg) {
        this(null, status, msg);
    }

    public Response(String content, int status) {
        this(content, status, null);
    }

    private Response(String content, int status, String msg) {
        this.content = content;
        this.status = status;
        this.msg = msg;
    }

    public String getContent() {
        return content;
    }

}
