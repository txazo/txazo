package org.txazo.weixin.develop.accesstoken;

import java.util.Date;

/**
 * AccessToken
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public class AccessToken {

    /** AccessToken */
    private String access_token;
    /** AccessToken的有效时间(秒) */
    private long expires_in;
    /** AccessToken的创建时间 */
    private Date createTime = new Date();

    public boolean isExpire() {
        return (System.currentTimeMillis() - createTime.getTime()) >= expires_in * 1000;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }

}
