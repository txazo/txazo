package org.txazo.monitor.system;

import org.txazo.monitor.common.util.ByteUtils;

import java.io.File;

/**
 * DiskMonitor
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.08.2015
 */
public class DiskMonitor {

    public static long getFreeSpace() {
        long freeSpace = 0L;
        File[] files = File.listRoots();
        for (File file : files) {
            freeSpace += file.getFreeSpace();
        }
        return ByteUtils.getGByte(freeSpace);
    }

}
