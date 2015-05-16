package org.txazo.test;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Date;

/**
 * AbstractTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.05.2015
 */
@RunWith(JUnit4.class)
public abstract class AbstractTest {

    private static final String pattern = "yyyy-MM-dd HH:mm:ss";

    protected static void print(Object msg) {
        System.out.println(DateFormatUtils.format(new Date(), pattern) + "\t" + msg);
    }

}
