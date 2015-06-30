package org.txazo.wx.app.authority.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.txazo.wx.app.authority.AuthorityType;
import org.txazo.wx.app.authority.annotation.AuthorityControl;
import org.txazo.wx.app.authority.service.AuthorityService;
import org.txazo.wx.app.common.util.RequestUtils;

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

    @Autowired
    private AuthorityService authorityService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Request: " + RequestUtils.getRequestURL(request));

        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            AuthorityControl authorityControl = handlerMethod.getMethodAnnotation(AuthorityControl.class);
            if (authorityControl == null) {
                authorityControl = handlerMethod.getBeanType().getAnnotation(AuthorityControl.class);
            }
            if (authorityControl == null || authorityControl.type() == AuthorityType.ALL) {
                return true;
            }
            if (authorityService.checkAuthority(request, response, authorityControl.type())) {
                return true;
            }
            response.sendRedirect("/authority/error.wx");
            return false;
        }
        return true;
    }

}
