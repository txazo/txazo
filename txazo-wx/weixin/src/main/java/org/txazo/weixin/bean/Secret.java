package org.txazo.weixin.bean;

/**
 * Secret
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public class Secret {

    private int agentid;
    private String sToken;
    private String sEncodingAESKey;

    public Secret(int agentid, String sToken, String sEncodingAESKey) {
        this.agentid = agentid;
        this.sToken = sToken;
        this.sEncodingAESKey = sEncodingAESKey;
    }

}
