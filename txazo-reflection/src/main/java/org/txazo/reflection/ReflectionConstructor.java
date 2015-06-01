package org.txazo.reflection;

import org.txazo.reflection.vo.Reflect;
import org.txazo.test.SuiteTest;
import org.txazo.test.annotation.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * ReflectionConstructor
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.lang.reflect.Constructor
 * @since 24.05.2015
 */
public class ReflectionConstructor extends SuiteTest {

    @Test
    public void test1() throws Exception {
        Class<Reflect> clazz = Reflect.class;

        /** 获取Constructor */
        Constructor<Reflect> constructor = clazz.getConstructor();
        assertNotNull(constructor);

        /** Constructor实例化类 */
        Reflect reflect = constructor.newInstance();
        assertNotNull(reflect);

        constructor = clazz.getDeclaredConstructor(int.class, String.class);
        assertNotNull(constructor);

        /** 构造方法参数 */
        assertSame(int.class, constructor.getParameterTypes()[0]);
        assertSame(String.class, constructor.getParameterTypes()[1]);
        reflect = constructor.newInstance(5, "txazo");
        assertEquals(5, reflect.getId());

        /** 获取所有的public Constructor */
        Constructor<?>[] constructors = clazz.getConstructors();
        assertEquals(2, constructors.length);
    }

}
