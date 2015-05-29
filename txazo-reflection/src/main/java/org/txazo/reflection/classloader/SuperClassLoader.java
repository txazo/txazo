package org.txazo.reflection.classloader;

/**
 * SuperClassLoader
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 29.05.2015
 */
public class SuperClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return super.loadClass(name);
    }

}
