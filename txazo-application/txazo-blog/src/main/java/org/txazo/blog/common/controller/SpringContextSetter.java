package org.txazo.blog.common.controller;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * SpringContextSetter
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 14.08.2015
 */
public abstract class SpringContextSetter {

    private ServletRequestAttributes getServletRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    protected HttpServletRequest getRequest() {
        return getServletRequestAttributes().getRequest();
    }

    protected HttpServletResponse getResponse() {
        return getServletRequestAttributes().getResponse();
    }

}
