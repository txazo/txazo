package org.txazo.test.util;

import org.txazo.test.SuiteTest;
import org.txazo.test.annotation.Suite;
import org.txazo.test.annotation.Test;

import java.io.IOException;

/**
 * PackageUtilsTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 17.05.2015
 */
public class PackageUtilsTest extends SuiteTest {

    @Test
    public void testGetClasses() throws IOException, ClassNotFoundException {
        print(PackageUtils.getClasses("org.txazo.test"));
    }

    @Test
    public void testGetClassesWithAnnotation() throws IOException, ClassNotFoundException {
        print(PackageUtils.getClassesWithAnnotation("org.txazo.test", Suite.class));
    }

}
