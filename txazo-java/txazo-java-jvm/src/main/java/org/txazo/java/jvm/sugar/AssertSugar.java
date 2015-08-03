package org.txazo.java.jvm.sugar;

import org.junit.Test;

import java.util.Random;

/**
 * AssertSugar
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.08.2015
 */
public class AssertSugar {

    /**
     * 断言 - 语法糖
     */

    @Test
    public void test() {
        int a = 1;
        int b = new Random().nextInt(2);
        assert a == b : "not equals";
    }

    static final boolean $assertionsDisabled1;

    static {
        $assertionsDisabled1 = AssertSugar.class.desiredAssertionStatus();
    }

    @Test
    public void testDecompile() {
        int a = 1;
        int b = new Random().nextInt(2);
        if (!$assertionsDisabled1 && !(a == b)) {
            throw new AssertionError("not equals");
        }
    }

}
