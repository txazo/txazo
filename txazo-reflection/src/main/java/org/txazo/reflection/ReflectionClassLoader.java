package org.txazo.reflection;

import org.txazo.test.SuiteTest;
import org.txazo.test.annotation.Test;

/**
 * ReflectionClassLoader
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.lang.ClassLoader
 * @since 28.05.2015
 */
public class ReflectionClassLoader extends SuiteTest {

    @Test
    public void test1() {
        /** AppClassLoader  */
        ClassLoader application = this.getClass().getClassLoader();
        /** ExtClassLoader */
        ClassLoader extension = application.getParent();
        /** BootstrpLoader */
        ClassLoader system = extension.getParent();
        assertEquals("sun.misc.Launcher$AppClassLoader", application.getClass().getName());
        assertEquals("sun.misc.Launcher$ExtClassLoader", extension.getClass().getName());
        assertNull(system);
    }

    @Test
    public void test2() throws ClassNotFoundException {
        Class<?> clazz = this.getClass().getClassLoader().loadClass("org.txazo.reflection.vo.Reflect");
        assertNotNull(clazz);
    }

    private class MyClassLoader extends ClassLoader {

        public MyClassLoader(ClassLoader parent) {
            super(parent);
        }

        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {
            return super.loadClass(name);
        }

    }

}
