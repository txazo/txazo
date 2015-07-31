package org.txazo.java.core.time;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateFormatTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.text.SimpleDateFormat
 * @see org.apache.commons.lang3.time.DateFormatUtils
 * @since 31.07.2015
 */
public class DateFormatTest {

    @Test
    public void test() throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = format.parse("2015-12-01 00:00:00");
        Assert.assertEquals("2015-12-01 00:00:00", DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss"));
    }

}
