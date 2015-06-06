package org.txazo.weixin.bean;

import java.util.Date;

/**
 * AccessToken
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public class AccessToken {

    private String access_token;
    private long expires_in;
    private Date accessTime = new Date();

    public boolean isExpire() {
        return (System.currentTimeMillis() - accessTime.getTime()) >= expires_in;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

}
