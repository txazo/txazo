package org.txazo.blog.common.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.txazo.blog.module.user.bean.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CommonUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 09.07.2015
 */
public abstract class CommonUtils {

    public static HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static HttpServletResponse getHttpServletResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    public static User getUser() {
        HttpServletRequest request = getHttpServletRequest();
        return request != null ? (User) request.getAttribute("user") : null;
    }

}
