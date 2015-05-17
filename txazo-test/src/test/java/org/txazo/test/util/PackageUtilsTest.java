package org.txazo.test.util;

import org.junit.Test;
import org.txazo.test.suite.SuiteTest;
import org.txazo.test.annotation.Suite;

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
        String packageName = "org.txazo.test";
        print(PackageUtils.getClasses(packageName));
        print(PackageUtils.getClassesWithAnnotation(packageName, Suite.class));
    }

}
