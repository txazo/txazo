package org.txazo.reflection.classloader;

import org.txazo.reflection.remote.api.VersionApi;
import org.txazo.reflection.vo.Reflect;
import org.txazo.test.SuiteTest;
import org.txazo.test.annotation.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * JarClassLoaderTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 29.05.2015
 */
public class JarClassLoaderTest extends SuiteTest {

    @Test
    public void test1() throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        URL jar = new URL("file:txazo-reflection-remote-service.jar");
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{jar}, Thread.currentThread().getContextClassLoader());
        Class<VersionApi> versionApiClass = (Class<VersionApi>) urlClassLoader.loadClass("org.txazo.reflection.remote.service.VersionService");
        VersionApi versionApi = versionApiClass.newInstance();
        assertEquals("1.0", versionApi.getVersion());
    }

    @Test
    public void test2() throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        URL jar = new URL("file:txazo-reflection-remote-service.jar");
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{jar}, Thread.currentThread().getContextClassLoader());
        Class<?> versionApiClass = urlClassLoader.loadClass("org.txazo.reflection.remote.service.VersionService");
        Class<?> versionApiClass1 = urlClassLoader.loadClass("org.txazo.reflection.remote.service.VersionService");

        URLClassLoader urlClassLoader2 = new URLClassLoader(new URL[]{jar}, Thread.currentThread().getContextClassLoader());
        Class<?> versionApiClass2 = urlClassLoader2.loadClass("org.txazo.reflection.remote.service.VersionService");

        assertSame(versionApiClass, versionApiClass1);
        assertSame(versionApiClass, versionApiClass2);
    }

    @Test
    public void test3() throws MalformedURLException {
        URL url = new URL("file:");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Reflect reflect = null;
        Class.forName("org.txazo.reflection.vo.Reflect");
        Thread.currentThread().getContextClassLoader().loadClass("org.txazo.reflection.vo.Reflect");
        Thread.currentThread().getContextClassLoader().loadClass("org.txazo.reflection.vo.Reflect");
    }

}
