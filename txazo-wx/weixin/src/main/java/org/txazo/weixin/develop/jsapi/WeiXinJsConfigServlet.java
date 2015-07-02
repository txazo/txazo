package org.txazo.weixin.develop.jsapi;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.txazo.weixin.WeiXinUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * WeiXinJsConfigServlet
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 01.07.2015
 */
public class WeiXinJsConfigServlet extends HttpServlet {

    private static final long serialVersionUID = 4962562612512553183L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String refer = request.getHeader("Referer");

        response.setContentType("application/json; charset=UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(JSON.toJSONString(WeiXinUtils.generateJsConfig(refer)));
        } catch (IOException e) {
            IOUtils.closeQuietly(out);
        }
    }

}
