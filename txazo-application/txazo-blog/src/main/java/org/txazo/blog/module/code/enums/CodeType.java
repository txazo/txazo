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

    LOGIN(Key.LOGIN_CODE, 16, 30 * 60),
    EMAIL_VALIDATE(Key.EMAIL_VALIDATE_CODE, 16, 24 * 60 * 60);

    private String key;
    private int length;
    private int expireTime;

    CodeType(String key, int length, int expireTime) {
        this.key = key;
        this.length = length;
        this.expireTime = expireTime;
    }

    public String getKey() {
        return key;
    }

    public int getLength() {
        return length;
    }

    public int getExpireTime() {
        return expireTime;
    }

}
