package org.txazo.blog.module.auth.service.impl;

import org.springframework.stereotype.Service;
import org.txazo.blog.common.cache.CacheService;
import org.txazo.blog.module.auth.service.AuthCodeService;
import org.txazo.blog.module.auth.util.AuthCodeUtils;

import javax.annotation.Resource;

/**
 * AuthCodeServiceImpl
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 13.08.2015
 */
@Service
public class AuthCodeServiceImpl implements AuthCodeService {

    private static final int EMAIL_VALIDATE_CODE_TIME = 24 * 60 * 60;
    private static final String EMAIL_VALIDATE_CODE_KEY = "Email_Validate_Code_";

    @Resource
    private CacheService cacheService;

    private String getEmailValidateCodeKey(String email) {
        return EMAIL_VALIDATE_CODE_KEY + email;
    }

    @Override
    public String getEmailValidateCode(String email) {
        String code = AuthCodeUtils.generateCode();
        cacheService.set(getEmailValidateCodeKey(email), code, EMAIL_VALIDATE_CODE_TIME);
        return code;
    }

    @Override
    public boolean checkEmailValidateCode(String email, String code) {
        String authCode = cacheService.get(getEmailValidateCodeKey(email), String.class);
        return authCode != null && authCode.equals(code);
    }

}
