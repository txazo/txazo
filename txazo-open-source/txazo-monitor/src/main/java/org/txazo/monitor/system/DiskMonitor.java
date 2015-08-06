package org.txazo.monitor.system;

import java.io.File;

/**
 * Created by txazo on 15/8/6.
 */
public class DiskMonitor {

    public static void main(String[] args) {
        // 磁盘
        long totalSpace = 0L;
        long usableSpace = 0L;
        File[] files = File.listRoots();
        for (File file : files) {
            totalSpace = file.getTotalSpace() / 1024 / 1024 / 1024;
            usableSpace = file.getUsableSpace() / 1024 / 1024 / 1024;
        }
        System.out.println("总的磁盘空间: " + totalSpace + "G");
        System.out.println("使用磁盘空间: " + usableSpace + "G");
        System.out.println("磁盘空间使用率: " + usableSpace * 100 / totalSpace + "G");
    }

}
