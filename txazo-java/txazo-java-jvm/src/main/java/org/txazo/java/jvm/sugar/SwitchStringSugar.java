package org.txazo.java.jvm.sugar;

import org.junit.Test;

/**
 * SwitchStringSugar
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.08.2015
 */
public class SwitchStringSugar {

    /**
     * switch字符串 - 语法糖
     *
     * 1) 先通过hashCode()来进行switch, 然后通过equals()验证
     */

    @Test
    public void test() {
        String mode = "ACTIVE";
        switch (mode) {
            case "ACTIVE":
                System.out.println(mode);
                break;
            case "PASSIVE":
                System.out.println(mode);
                break;
        }
    }

    @Test
    public void testDecompile() {
        String mode = "ACTIVE";
        String s;
        switch ((s = mode).hashCode()) {
            default:
                break;
            case 1925346054:
                if (s.equals("ACTIVE")) {
                    System.out.println(mode);
                }
                break;
            case -74056953:
                if (s.equals("PASSIVE")) {
                    System.out.println(mode);
                }
                break;
        }
    }

}