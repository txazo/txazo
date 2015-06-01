package org.txazo.reflection;

import org.txazo.test.SuiteTest;
import org.txazo.test.annotation.Test;

import java.lang.reflect.Modifier;

/**
 * ReflectionModifier
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.lang.reflect.Modifier
 * @since 13.05.2015
 */
public class ReflectionModifier extends SuiteTest {

    @Test
    public void test1() {
        assertTrue(Modifier.isPublic(ReflectionModifier.class.getModifiers()));
    }

}
