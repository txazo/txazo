package org.txazo.reflection;

import org.txazo.reflection.anno.PkgAnno;
import org.txazo.test.SuiteTest;
import org.txazo.test.annotation.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;

/**
 * ReflectionPackage
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.lang.Package
 * @see java.util.jar.Manifest
 * @since 13.05.2015
 */
public class ReflectionPackage extends SuiteTest {

    @Test
    public void test1() {
        /** Package */
        Package pkg = Class.class.getPackage();
        assertEquals("java.lang", pkg.getName());
        assertEquals("Java Platform API Specification", pkg.getSpecificationTitle());
        assertEquals("Oracle Corporation", pkg.getSpecificationVendor());
        // assertEquals("1.7", pkg.getSpecificationVersion());
        assertEquals("Java Runtime Environment", pkg.getImplementationTitle());
        assertEquals("Oracle Corporation", pkg.getImplementationVendor());
        // assertEquals("1.7.0_75", pkg.getImplementationVersion());
    }

    @Test
    public void test2() {
        Package pkg = Package.getPackage("org.txazo.reflection");

        /** package-info包注解 */
        assertNotNull(pkg.getAnnotation(PkgAnno.class));

        /** package-info包类 */
        assertEquals(1, new PkgClass().pkg());

        /** package-info包常量 */
        assertEquals(1, PkgConstant.NUM);
    }

    @Test
    public void test3() throws IOException {
        /** Manifest */
        String classPath = this.getClass().getResource("/").getPath();
        String jarFile = classPath + "../txazo-java-reflection-1.0.jar";
        JarInputStream jis = new JarInputStream(new FileInputStream(jarFile), false);
        Manifest manifest = jis.getManifest();
        Attributes attr = manifest.getMainAttributes();
        Map.Entry entry = null;
        for (Iterator<Map.Entry<Object, Object>> i = attr.entrySet().iterator(); i.hasNext(); ) {
            entry = i.next();
            println(entry.getKey() + " : " + entry.getValue());
        }

        /** MANIFEST.MF读入  */
        manifest.read(new FileInputStream(this.getClass().getResource("/manifest.mf").getPath()));
        /** MANIFEST.MF写出 */
        manifest.write(new FileOutputStream(this.getClass().getResource("/manifest.mf").getPath()));
    }

    /**
     * MANIFEST.MF
     *
     * 1) Main-Class: org.txazo.reflection.Main
     * 2) Class-Path: lib/commons-lang3-3.4.jar
     */

}
