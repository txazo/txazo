package org.txazo.blog.common.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.txazo.blog.common.cache.CacheService;

import javax.annotation.Resource;
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

    @Resource
    private CacheService cacheService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ip = request.getRemoteHost();
        String key = DEFEND_ATTACK_IP_KEY + ip;
        Integer count = (Integer) cacheService.get(key);
        if (count == null) {
            count = 0;
        }
        if (count >= MAX_TIMES) {
            return false;
        }
        cacheService.set(key, count + 1);
        return true;
    }

}
