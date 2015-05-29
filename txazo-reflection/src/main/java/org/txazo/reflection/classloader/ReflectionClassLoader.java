package org.txazo.reflection.classloader;

/**
 * ReflectionClassLoader
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 29.05.2015
 */
class ReflectionClassLoader extends ClassLoader {

    public ReflectionClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

}
