package org.txazo.blog.common.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.txazo.blog.common.cache.CacheKey;
import org.txazo.blog.common.cache.RedisCacheService;
import org.txazo.blog.common.constant.Key;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * DefendAttackInterceptor
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 30.06.2015
 */
@Component("defendAttackInterceptor")
public class DefendAttackInterceptor extends HandlerInterceptorAdapter {

    private static final int MAX_TIMES = 50;
    private static final String DEFEND_ATTACK_IP_KEY = "DEFEND_ATTACK_IP_";

    @Autowired
    private RedisCacheService redisCacheService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ip = request.getRemoteHost();
        CacheKey key = new CacheKey(Key.DEFEND_ATTACK_IP, ip);
        Integer count = (Integer) redisCacheService.get(key);
        if (count == null) {
            count = 0;
            redisCacheService.set(key, 0, 10);
        }
        if (count >= MAX_TIMES) {
            response.sendRedirect("/error/restrict");
            return false;
        }
        redisCacheService.increase(key);
        return true;
    }

}
