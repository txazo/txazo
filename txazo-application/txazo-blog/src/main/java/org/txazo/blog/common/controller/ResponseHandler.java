package org.txazo.blog.common.controller;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * ResponseHandler
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 14.08.2015
 */
public abstract class ResponseHandler extends SpringContextSetter {

    protected void responseText(String data) {
        response("text/plain", data);
    }

    protected void responseXml(String data) {
        response("text/xml", data);
    }

    protected void responseHtml(String data) {
        response("text/html", data);
    }

    protected void responseJavaScript(String data) {
        response("text/javascript", data);
    }

    protected void responseJson(String data) {
        response("application/json", data);
    }

    private void response(String contentType, String data) {
        HttpServletResponse response = getResponse();
        response.setContentType(contentType + "; charset=utf-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        try (PrintWriter out = response.getWriter()) {
            out.write(data);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
