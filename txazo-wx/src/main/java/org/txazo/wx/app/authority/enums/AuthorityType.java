package org.txazo.wx.app.authority.enums;

/**
 * AuthorityType
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 30.06.2015
 */
public enum AuthorityType {

    ADMIN(0xffff),
    EMAIL(0x0001),
    MEMORY(0x0002),
    REMIND(0x0004),
    ALL(0x0000);

    private int id;

    AuthorityType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static void main(String[] args) {
        System.out.println(ADMIN.getId() & MEMORY.getId());
        System.out.println(EMAIL.getId() & MEMORY.getId());
    }

}
