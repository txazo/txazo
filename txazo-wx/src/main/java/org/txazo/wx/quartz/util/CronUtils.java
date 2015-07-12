package org.txazo.wx.quartz.util;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.quartz.CronExpression;

import java.util.Date;

public abstract class CronUtils {

    public static boolean isValidCronExpression(String expression) {
        try {
            CronExpression cron = new CronExpression(expression);

            Date d1 = cron.getNextValidTimeAfter(new Date());
            Date d2 = cron.getNextValidTimeAfter(d1);
            Date d3 = cron.getNextValidTimeAfter(d2);
            Date d4 = cron.getNextValidTimeAfter(d3);
            System.out.println(DateFormatUtils.format(d1, "yyyy-MM-dd HH:mm:ss"));
            System.out.println(DateFormatUtils.format(d2, "yyyy-MM-dd HH:mm:ss"));
            System.out.println(DateFormatUtils.format(d3, "yyyy-MM-dd HH:mm:ss"));
            System.out.println(DateFormatUtils.format(d4, "yyyy-MM-dd HH:mm:ss"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isValidCronExpression(""));
        System.out.println(isValidCronExpression("0 */10 * *"));
        System.out.println(isValidCronExpression("0 */10 * * * ?"));
    }

}
