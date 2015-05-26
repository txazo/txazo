package org.txazo.reflection;

import org.txazo.reflection.anno.FieldAnno;
import org.txazo.reflection.vo.Reflect;
import org.txazo.test.SuiteTest;
import org.txazo.test.annotation.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * ReflectionField
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.lang.reflect.Field
 * @since 15.05.2015
 */
public class ReflectionField extends SuiteTest {

    @Test
    public void test1() throws Exception {
        /** 获取全部的Field */
        Field[] fields = Reflect.class.getDeclaredFields();
        for (Field field : fields) {
            print(field.getName());
        }
    }

    @Test
    public void test2() throws NoSuchFieldException, IllegalAccessException {
        /** 根据名称查找Field */
        Field field = Reflect.class.getDeclaredField("id");
        assertNotNull(field);

        /** Field的类型 */
        Class<?> fieldType = field.getType();
        assertSame(int.class, fieldType);

        /** Field的注解 */
        FieldAnno fieldAnno = field.getAnnotation(FieldAnno.class);
        assertEquals("id", fieldAnno.desc());

        /** Field的修饰符 */
        int modifiers = field.getModifiers();
        assertTrue(Modifier.isPrivate(modifiers));

        /** Field的get/set */
        Reflect reflect = new Reflect(1, "txazo");
        field.setAccessible(true);
        assertEquals(1, field.get(reflect));
        field.set(reflect, 5);
        assertEquals(5, reflect.getId());
    }

    @Test
    public void test3() throws NoSuchFieldException, IllegalAccessException {
        /** 静态变量的Field */
        Reflect.NUM = 1;
        Field field = Reflect.class.getDeclaredField("NUM");
        assertEquals(1, field.get(null));
        field.set(null, 5);
        assertEquals(5, Reflect.NUM);
    }

}
