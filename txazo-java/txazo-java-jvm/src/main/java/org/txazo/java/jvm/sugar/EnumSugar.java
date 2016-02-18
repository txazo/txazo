package org.txazo.java.jvm.sugar;

/**
 * EnumSugar
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.08.2015
 */
public class EnumSugar {

    /**
     * 枚举 - 语法糖
     */

    enum Sugar {

        THIN, SWEET

    }

}

/**
 * 枚举 - 反编译
 */
public final class Color extends Enum<Color> {

    public static final Color RED;
    public static final Color GREEN;
    public static final Color BLUE;
    private static Color $VALUES[];

    static {
        RED = new Color("RED", 0);
        GREEN = new Color("GREEN", 1);
        BLUE = new Color("BLUE", 2);
        $VALUES = (new Color[]{RED, GREEN, BLUE});
    }

    private Color(String name, int ordinal) {
        super(name, ordinal);
    }

    public static Color[] values() {
        return $VALUES.clone();
    }

    public static Color valueOf(String name) {
        return Enum.valueOf(Color.class, name);
    }

}
