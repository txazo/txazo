package org.txazo.java.core.time;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.Test;

import java.util.Calendar;
import java.util.TimeZone;

/**
 * TimeZoneTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.util.TimeZone
 * @since 31.07.2015
 */
public class TimeZoneTest {

    /**
     * TimeZone
     *
     * 1) 时区
     */

    @Test
    public void test() {
        Calendar c = Calendar.getInstance();
        /** 默认时区 */
        c.setTimeZone(TimeZone.getDefault());
        System.out.println(DateFormatUtils.format(c, "yyyy-MM-dd HH:mm:ss"));
        c.setTimeZone(TimeZone.getTimeZone("Etc/GMT+8"));
        System.out.println(DateFormatUtils.format(c, "yyyy-MM-dd HH:mm:ss"));

        /** 所有时区 */
        for (String id : TimeZone.getAvailableIDs()) {
            System.out.println(id);
        }
    }

}
