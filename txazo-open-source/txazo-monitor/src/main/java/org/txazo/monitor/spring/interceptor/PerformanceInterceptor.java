package org.txazo.monitor.spring.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * PerformanceInterceptor
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 06.08.2015
 */
public class PerformanceInterceptor extends HandlerInterceptorAdapter {

    private ThreadLocal<Long> startTime = new ThreadLocal<Long>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        startTime.set(System.nanoTime());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long time = (System.nanoTime() - startTime.get()) / 1000000;
        String uri = request.getRequestURI();
        System.out.println("执行时间: " + uri + ", " + time);
    }

}
