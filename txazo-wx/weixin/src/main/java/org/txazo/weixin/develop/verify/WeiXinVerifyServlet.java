package org.txazo.weixin.develop.verify;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * WeiXinVerifyServlet
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.06.2015
 */
public class WeiXinVerifyServlet extends HttpServlet {

    private static final long serialVersionUID = 526431739344092302L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg_signature = request.getParameter("msg_signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        PrintWriter out = null;
        try {
            out = response.getWriter();
            String sEchoStr = VerifyUtils.verifyURL(msg_signature, timestamp, nonce, echostr);
            out.print(sEchoStr);
        } finally {
            IOUtils.closeQuietly(out);
        }
    }

}
