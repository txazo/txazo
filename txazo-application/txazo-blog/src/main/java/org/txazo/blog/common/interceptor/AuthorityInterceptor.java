package org.txazo.blog.common.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.txazo.blog.common.enums.RequestConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AuthorityInterceptor
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 30.06.2015
 */
@Component("authorityInterceptor")
public class AuthorityInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            RequestConfig requestConfig = handlerMethod.getMethodAnnotation(RequestConfig.class);
            if (requestConfig == null) {
                requestConfig = handlerMethod.getBeanType().getAnnotation(RequestConfig.class);
            }
            if (requestConfig == null) {
                return true;
            }
        }
        return true;
    }

}
