package org.txazo.reflection;

import org.junit.Assert;
import org.junit.Test;
import org.txazo.reflection.vo.Reflect;
import org.txazo.test.SuiteTest;

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
        Constructor<Reflect> constructor = Reflect.class.getConstructor(null);
        Reflect reflect = constructor.newInstance(null);
        Assert.assertNotNull(reflect);

        Constructor<?>[] constructors = Reflect.class.getConstructors();
        for (Constructor<?> c : constructors) {
            print(c.getName());
        }
    }

}
