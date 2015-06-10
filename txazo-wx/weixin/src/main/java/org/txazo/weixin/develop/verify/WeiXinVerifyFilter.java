package org.txazo.weixin.develop.verify;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * WeiXinVerifyFilter
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 09.06.2015
 */
public class WeiXinVerifyFilter implements Filter {

    private static final String WEIXIN_VERIFY_DEFAULT_URI = "/weixin/filter/verify";

    private String weiXinVerifyUri;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        weiXinVerifyUri = filterConfig.getInitParameter("uri");
        if (StringUtils.isBlank(weiXinVerifyUri)) {
            weiXinVerifyUri = WEIXIN_VERIFY_DEFAULT_URI;
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getRequestURI().equals(weiXinVerifyUri)) {
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
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }

}
