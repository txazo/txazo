package org.txazo.wx.app.common.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * RequestUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 30.06.2015
 */
public abstract class RequestUtils {

    public static String getRequestURL(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        String query = request.getQueryString();
        return url + (StringUtils.isBlank(query) ? StringUtils.EMPTY : "?" + query);
    }

}
