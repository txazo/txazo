package org.txazo.java.jvm.sugar;

import org.junit.Assert;
import org.junit.Test;

/**
 * AutoBoxSugar
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.08.2015
 */
public class AutoBoxSugar {

    /**
     * 自动装箱拆箱 - 语法糖
     *
     * 1) 装箱: 基本数据类型转换为包装类型
     * 2) 拆箱: 包装类型转换为基本数据类型
     */

    @Test
    public void test() {
        Integer a = 10;
        int b = a;
        Assert.assertTrue(a == b);
        Assert.assertTrue(a.equals(b));
    }

    @Test
    public void testDecompile() {
        Integer a = Integer.valueOf(10);
        int b = a.intValue();
        Assert.assertTrue(a.intValue() == b);
        Assert.assertTrue(a.equals(Integer.valueOf(b)));
    }

}
