package org.txazo.java.jvm.sugar;

import org.junit.Test;

/**
 * IfSugar
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.08.2015
 */
public class IfSugar {

    /**
     * 条件编译 - 语法糖
     *
     * 1) 编译器对代码进行优化, 对于条件永远为false的语句, Java编译器将不会对其生成字节码
     */

    private static final boolean DEBUG = false;

    @Test
    public void test() {
        if (DEBUG) {
            System.out.println("DEBUG");
        }

        final boolean flag = true;
        if (flag) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    @Test
    public void testDecompile() {
        boolean flag = true;
        System.out.println("true");
    }

}
