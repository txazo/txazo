package org.txazo.weixin.filter;

import org.apache.commons.io.IOUtils;
import org.txazo.weixin.verify.VerifyUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * AgentVerifyFilter
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 09.06.2015
 */
public class AgentVerifyFilter implements Filter {

    private static final String AGENT_VERIFY_URL = "/weixin/verify";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getRequestURI().equals(AGENT_VERIFY_URL)) {
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

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }

}
