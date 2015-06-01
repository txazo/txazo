package org.txazo.reflection;

import org.txazo.reflection.vo.Reflect;
import org.txazo.test.SuiteTest;
import org.txazo.test.annotation.Test;

/**
 * ReflectionMember
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.lang.reflect.Member
 * @since 01.06.2015
 */
public class ReflectionMember extends SuiteTest {

    @Test
    public void test1() throws Exception {
        Class<?> clazz = Reflect.class;

        /** public、递归继承(Constructor除外) */
        clazz.getClasses();
        clazz.getField("NUM");
        clazz.getFields();
        clazz.getConstructor();
        clazz.getConstructors();
        clazz.getMethod("getName");
        clazz.getMethods();

        /** private、不可继承 */
        clazz.getDeclaredClasses();
        clazz.getDeclaredField("id");
        clazz.getDeclaredFields();
        clazz.getDeclaredConstructor();
        clazz.getDeclaredConstructors();
        clazz.getDeclaredMethod("privateMethod");
        clazz.getDeclaredMethods();
    }

}
