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
     * 枚举语法糖
     */

    enum Sugar {

        THIN, SWEET

    }

}

/**
 * 枚举 - 反编译
 */
//final class SugarDeCompile extends Enum {
//
//    private SugarDeCompile(String s, int i) {
//        super(s, i);
//    }
//
//    public static SugarDeCompile[] values() {
//        SugarDeCompile asugardecompile[];
//        int i;
//        SugarDeCompile asugardecompile1[];
//        System.arraycopy(asugardecompile = ENUM$VALUES, 0, asugardecompile1 = new SugarDeCompile[i = asugardecompile.length], 0, i);
//        return asugardecompile1;
//    }
//
//    public static SugarDeCompile valueOf(String s) {
//        return Enum.valueOf(SugarDeCompile.class, s);
//    }
//
//    public static final SugarDeCompile THIN;
//    public static final SugarDeCompile SWEET;
//    private static final SugarDeCompile ENUM$VALUES[];
//
//    static {
//        THIN = new SugarDeCompile("THIN", 0);
//        SWEET = new SugarDeCompile("SWEET", 1);
//        ENUM$VALUES = (new SugarDeCompile[]{THIN, SWEET});
//    }
//
//}
