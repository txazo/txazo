package org.txazo.wx.app.memory.enums;

/**
 * MemoryType
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 27.06.2015
 */
public enum MemoryType {

    ROOT(1), TREE(2), NODE(3);

    private int id;

    MemoryType(int id) {
        this.id = id;
    }

    public static boolean contains(int id) {
        for (MemoryType type : values()) {
            if (type.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

}
