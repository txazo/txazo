package org.txazo.reflection;

import org.txazo.reflection.anno.*;
import org.txazo.reflection.vo.AnnoClass;
import org.txazo.test.SuiteTest;
import org.txazo.test.annotation.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * ReflectionClass
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
        assertNotNull(Package.getPackage("org.txazo.reflection").getAnnotation(PkgAnno.class));
    }

    @Test
    public void test2() {
        assertNotNull(clazz.getAnnotation(ClassAnno.class));
    }

    @Test
    public void test3() throws NoSuchFieldException {
        assertNotNull(clazz.getDeclaredField("id").getAnnotation(FieldAnno.class));
    }

    @Test
    public void test4() throws NoSuchMethodException {
        assertNotNull(clazz.getDeclaredMethod("setId", int.class).getAnnotation(MethodAnno.class));
    }

    @Test
    public void test5() throws NoSuchMethodException {
        Method method = clazz.getDeclaredMethod("param", int.class, String.class);
        Annotation[][] annotations = method.getParameterAnnotations();
        assertEquals("id", ((ParamAnno) annotations[0][0]).name());
        assertEquals("name", ((ParamAnno) annotations[1][0]).name());
    }

}
