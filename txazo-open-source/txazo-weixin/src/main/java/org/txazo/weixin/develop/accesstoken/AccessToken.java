package org.txazo.weixin.develop.accesstoken;

/**
 * AccessToken
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
class AccessToken {

    /** AccessToken */
    private String access_token;
    /** AccessToken的有效时间(秒) */
    private long expires_in;
    /** AccessToken的创建时间 */
    private long createTime = System.currentTimeMillis();

    /**
     * 是否过期
     *
     * @return
     */
    public boolean isExpire() {
        return (System.currentTimeMillis() - createTime) >= (expires_in - 60) * 1000;
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
