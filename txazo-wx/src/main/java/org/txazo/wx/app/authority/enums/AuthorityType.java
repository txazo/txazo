package org.txazo.wx.app.authority.enums;

/**
 * AuthorityType
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 30.06.2015
 */
public enum AuthorityType {

    ADMIN(0xffffffff),
    EMAIL(0x00000001),
    MEMORY(0x00000010),
    MEMORY_READ(0x00000020),
    REMIND(0x00000100),
    ALL(0x00000000);

    private int id;

    AuthorityType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
