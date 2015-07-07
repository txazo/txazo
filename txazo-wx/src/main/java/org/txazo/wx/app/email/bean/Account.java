package org.txazo.wx.app.email.bean;

import org.txazo.weixin.annotation.EntityPath;
import org.txazo.weixin.xml.XmlEntity;

/**
 * Account
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 16.06.2015
 */
@EntityPath(path = "email.account")
public class Account implements XmlEntity {

    @EntityPath(path = "email.account.admin")
    private String user;
    @EntityPath(path = "email.account.passwd")
    private String passwd;
    @EntityPath(path = "email.account.protocol")
    private String protocol;
    @EntityPath(path = "email.account.host")
    private String host;
    @EntityPath(path = "email.account.port")
    private String port;
    @EntityPath(path = "email.account.auth")
    private String auth;
    @EntityPath(path = "email.account.ssl")
    private String ssl;

    public Account() {
    }

    public String getUser() {
        return user;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        try {
            return Integer.parseInt(port);
        } catch (Exception e) {
            return 0;
        }
    }

    public String getAuth() {
        return auth;
    }

    public boolean isSSL() {
        return Boolean.parseBoolean(ssl);
    }

}
