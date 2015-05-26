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
    public void test1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Reflect> clazz = Reflect.class;

        Constructor<Reflect> constructor = clazz.getConstructor(null);
        assertNotNull(constructor);
        Reflect reflect = constructor.newInstance(null);
        assertNotNull(reflect);

        constructor = clazz.getDeclaredConstructor(new Class[]{int.class, String.class});
        assertNotNull(constructor);
        reflect = constructor.newInstance(5, "txazo");
        assertEquals(5, reflect.getId());

        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> c : constructors) {
            print(c.getName());
        }
    }

}
