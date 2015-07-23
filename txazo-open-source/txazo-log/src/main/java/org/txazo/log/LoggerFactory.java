package org.txazo.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * LoggerFactory
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 02.06.2015
 */
public class LoggerFactory {

    public static Logger getLogger() {
        return LogManager.getLogger();
    }

}
