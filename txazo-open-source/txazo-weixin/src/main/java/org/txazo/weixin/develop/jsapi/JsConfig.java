package org.txazo.weixin.develop.jsapi;

import java.io.Serializable;

/**
 * JsConfig
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 02.07.2015
 */
public class JsConfig implements Serializable {

    private static final long serialVersionUID = 4836466978388351628L;

    private String appId;
    private long timestamp;
    private String nonceStr;
    private String signature;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

}
