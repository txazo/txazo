package org.txazo.reflection;

import org.junit.Assert;
import org.junit.Test;
import org.txazo.reflection.vo.ClassVo;
import org.txazo.test.AbstractTest;

/**
 * ClassTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 13.05.2015
 */
public class ClassTest extends AbstractTest {

    @Test
    public void test1() throws ClassNotFoundException {
        Class<?> c1 = ClassVo.class;
        Class<?> c2 = new ClassVo().getClass();
        Class<?> c3 = Class.forName("org.txazo.reflection.vo.ClassVo");
        Assert.assertSame(c1, c2);
        Assert.assertSame(c1, c3);
    }

}
