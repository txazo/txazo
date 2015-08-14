package org.txazo.blog.module.code.service.impl;

import org.springframework.stereotype.Service;
import org.txazo.blog.common.cache.CacheKey;
import org.txazo.blog.common.cache.CacheService;
import org.txazo.blog.common.util.CodeUtils;
import org.txazo.blog.module.code.enums.CodeType;
import org.txazo.blog.module.code.service.CodeService;

import javax.annotation.Resource;

/**
 * CodeServiceImpl
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 13.08.2015
 */
@Service
public class CodeServiceImpl implements CodeService {

    @Resource
    private CacheService cacheService;

    @Override
    public String getCode(int userId, CodeType type) {
        String code = CodeUtils.generateCode(16);
        cacheService.set(new CacheKey(type.getKey(), userId), code, type.getExpireTime());
        return code;
    }

    @Override
    public boolean validateCode(int userId, CodeType type, String code) {
        String cacheCode = cacheService.get(new CacheKey(type.getKey(), userId), String.class);
        return cacheCode != null && cacheCode.equals(code);
    }

}
