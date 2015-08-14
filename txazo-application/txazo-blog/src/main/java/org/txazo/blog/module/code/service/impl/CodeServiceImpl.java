package org.txazo.blog.module.code.service.impl;

import org.springframework.stereotype.Service;
import org.txazo.blog.common.cache.CacheKey;
import org.txazo.blog.common.cache.CacheService;
import org.txazo.blog.common.constant.Key;
import org.txazo.blog.common.util.CodeUtils;
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

    private static final int EMAIL_VALIDATE_CODE_TIME = 24 * 60 * 60;
    private static final String EMAIL_VALIDATE_CODE_KEY = "Email_Validate_Code_";

    @Resource
    private CacheService cacheService;

    private CacheKey getEmailValidateCodeKey(String email) {
        return new CacheKey(Key.EMAIL_VALIDATE_CODE, email);
    }

    @Override
    public String getEmailValidateCode(String email) {
        String code = CodeUtils.generateCode(16);
        cacheService.set(getEmailValidateCodeKey(email), code, EMAIL_VALIDATE_CODE_TIME);
        return code;
    }

    @Override
    public boolean checkEmailValidateCode(String email, String code) {
        String authCode = cacheService.get(getEmailValidateCodeKey(email), String.class);
        return authCode != null && authCode.equals(code);
    }

}
