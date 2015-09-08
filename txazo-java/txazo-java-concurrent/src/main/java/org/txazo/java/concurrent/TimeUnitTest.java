package org.txazo.java.concurrent;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * TimeUnitTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.util.concurrent.TimeUnit
 * @since 2015-09-08
 */
public class TimeUnitTest {

    @Test
    public void test() {
        Assert.assertEquals(TimeUnit.DAYS.toHours(1), TimeUnit.HOURS.toHours(1) * 24);
        Assert.assertEquals(TimeUnit.HOURS.toMinutes(1), TimeUnit.MINUTES.toMinutes(1) * 60);
        Assert.assertEquals(TimeUnit.MINUTES.toSeconds(1), TimeUnit.SECONDS.toSeconds(1) * 60);
        Assert.assertEquals(TimeUnit.SECONDS.toMillis(1), TimeUnit.MILLISECONDS.toMillis(1) * 1000);
        Assert.assertEquals(TimeUnit.MILLISECONDS.toMicros(1), TimeUnit.MICROSECONDS.toMicros(1) * 1000);
        Assert.assertEquals(TimeUnit.MICROSECONDS.toNanos(1), TimeUnit.NANOSECONDS.toNanos(1) * 1000);
    }


}
