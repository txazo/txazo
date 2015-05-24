package org.txazo.reflection;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.junit.Test;
import org.txazo.reflection.anno.PkgAnno;
import org.txazo.test.junit4.suite.SuiteTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;

/**
 * ReflectPackage
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.lang.Package
 * @since 13.05.2015
 */
public class ReflectPackage extends SuiteTest {

    @Test
    public void test1() {
        Package pkg = CollectionUtils.class.getPackage();

        print(pkg.getName());

        System.out.println(pkg.getSpecificationVersion());
        System.out.println(pkg.getSpecificationTitle());
        System.out.println(pkg.getSpecificationVendor());

        System.out.println(pkg.getImplementationVersion());
        System.out.println(pkg.getImplementationTitle());
        System.out.println(pkg.getImplementationVendor());
    }

    @Test
    public void test2() {
        Package pkg = Package.getPackage("org.txazo.reflection");

        /** package-info包注解 */
        Assert.assertNotNull(pkg.getAnnotation(PkgAnno.class));

        /** package-info包类 */
        Assert.assertEquals(1, new PkgClass().pkg());

        /** package-info包常量 */
        Assert.assertEquals(1, PkgConstant.NUM);
    }

    @Test
    public void test3() throws IOException {
        /** Manifest */
        String jarFile = "/Users/txazo/TxazoCode/txazo/txazo-reflection/target/txazo-reflection-1.0.jar";
        JarInputStream jis = new JarInputStream(new FileInputStream(jarFile), false);
        Manifest manifest = jis.getManifest();
        Attributes attr = manifest.getMainAttributes();
        Map.Entry entry = null;
        for (Iterator<Map.Entry<Object, Object>> i = attr.entrySet().iterator(); i.hasNext(); ) {
            entry = i.next();
            print(entry.getKey() + " : " + entry.getValue());
        }
    }

}