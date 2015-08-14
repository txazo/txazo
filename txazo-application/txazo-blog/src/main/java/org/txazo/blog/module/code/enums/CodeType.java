package org.txazo.blog.module.code.enums;

import org.txazo.blog.common.constant.Key;

/**
 * CodeType
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 14.08.2015
 */
public enum CodeType {

    EMAIL_VALIDATE(Key.EMAIL_VALIDATE_CODE, 24 * 60 * 60);

    private String key;
    private int expireTime;

    CodeType(String key, int expireTime) {
        this.key = key;
        this.expireTime = expireTime;
    }

    public int getExpireTime() {
        return expireTime;
    }

    public String getKey() {
        return key;
    }

}
