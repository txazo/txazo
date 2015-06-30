package org.txazo.wx.app.authority;

/**
 * AuthorityType
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 30.06.2015
 */
public enum AuthorityType {

    WRITE(1), READ(2), ALL(3);

    private int id;

    AuthorityType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
