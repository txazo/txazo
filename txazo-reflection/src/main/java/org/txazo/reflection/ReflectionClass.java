package org.txazo.reflection;

import org.junit.Assert;
import org.junit.Test;
import org.txazo.reflection.vo.ClassVo;
import org.txazo.test.AbstractTest;

/**
 * ReflectionClass
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 13.05.2015
 */
public class ReflectionClass extends AbstractTest {

    @Test
    public void test1() throws ClassNotFoundException {
        Class<?> c1 = ClassVo.class;
        Class<?> c2 = new ClassVo().getClass();
        Class<?> c3 = Class.forName("org.txazo.reflection.vo.ClassVo");
        Class<?> c4 = Thread.currentThread().getContextClassLoader().loadClass("org.txazo.reflection.vo.ClassVo");
        Assert.assertSame(c1, c2);
        Assert.assertSame(c1, c3);
        Assert.assertSame(c1, c4);
    }

    @Test
    public void test2() {
        Class<?> clazz = ClassVo.class;
        /** 类名 */
        Assert.assertEquals("ClassVo", clazz.getSimpleName());
        /** 全限定类名 */
        Assert.assertEquals("org.txazo.reflection.vo.ClassVo", clazz.getName());
    }

}
