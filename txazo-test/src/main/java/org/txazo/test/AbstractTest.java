package org.txazo.test;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.txazo.test.assertion.Assert;

import java.util.Date;

/**
 * AbstractTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.05.2015
 */
public abstract class AbstractTest extends Assert {

    private static final String pattern = "yyyy-MM-dd HH:mm:ss";

    protected static void print(Object msg) {
        System.err.println(DateFormatUtils.format(new Date(), pattern) + " [INFO] " + msg);
    }

}
