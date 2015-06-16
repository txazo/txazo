package org.txazo.wx.app.email.enums;

/**
 * Protocol
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 15.06.2015
 */
public enum Protocol {

    SMTP("smtp"), POP3("pop3"), IMAP("imap");

    private String id;

    Protocol(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
