package org.txazo.reflection;

import org.txazo.reflection.anno.*;
import org.txazo.reflection.vo.AnnoClass;
import org.txazo.test.SuiteTest;
import org.txazo.test.annotation.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * ReflectionAnnotation
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.lang.annotation.Annotation
 * @since 28.05.2015
 */
public class ReflectionAnnotation extends SuiteTest {

    private Class<AnnoClass> clazz = AnnoClass.class;

    @Test
    public void test1() {
        /** 包注解 */
        assertNotNull(Package.getPackage("org.txazo.reflection").getAnnotation(PkgAnno.class));
    }

    @Test
    public void test2() {
        /** 类注解 */
        assertNotNull(clazz.getAnnotation(ClassAnno.class));
    }

    @Test
    public void test3() throws NoSuchMethodException {
        /** 构造方法注解 */
        assertNotNull(clazz.getConstructor().getAnnotation(ConstructorAnno.class));
    }

    @Test
    public void test4() throws NoSuchFieldException {
        /** 变量注解 */
        assertNotNull(clazz.getDeclaredField("id").getAnnotation(FieldAnno.class));
    }

    @Test
    public void test5() throws NoSuchMethodException {
        /** 方法注解 */
        assertNotNull(clazz.getDeclaredMethod("setId", int.class).getAnnotation(MethodAnno.class));
    }

    @Test
    public void test6() throws NoSuchMethodException {
        /** 方法参数注解 */
        Method method = clazz.getDeclaredMethod("param", int.class, String.class);
        Annotation[][] annotations = method.getParameterAnnotations();
        assertEquals("id", ((ParamAnno) annotations[0][0]).name());
        assertEquals("name", ((ParamAnno) annotations[1][0]).name());
    }

}
