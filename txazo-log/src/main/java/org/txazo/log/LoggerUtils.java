package org.txazo.log;

/**
 * LoggerUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 02.06.2015
 */
public abstract class LoggerUtils {

    public static void log(Object msg) {
        LoggerFactory.getLogger().info(msg);
    }

    public static void log(Object msg, Throwable t) {
        LoggerFactory.getLogger().info(msg, t);
    }

    public static void log(String msg, Object... params) {
        LoggerFactory.getLogger().info(msg, params);
    }

    public static void log(String msg, Throwable t) {
        LoggerFactory.getLogger().info(msg, t);
    }

}
