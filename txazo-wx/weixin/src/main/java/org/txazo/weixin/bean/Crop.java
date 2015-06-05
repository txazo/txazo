package org.txazo.weixin.bean;

import java.io.Serializable;

/**
 * Crop
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public class Crop implements XmlBean, Serializable {

    private static final long serialVersionUID = 7586766818534635880L;

    private String corpid;
    private String corpsecret;

    public Crop(String corpid, String corpsecret) {
        this.corpid = corpid;
        this.corpsecret = corpsecret;
    }

    public String getCorpid() {
        return corpid;
    }

    public void setCorpid(String corpid) {
        this.corpid = corpid;
    }

    public String getCorpsecret() {
        return corpsecret;
    }

    public void setCorpsecret(String corpsecret) {
        this.corpsecret = corpsecret;
    }

}
