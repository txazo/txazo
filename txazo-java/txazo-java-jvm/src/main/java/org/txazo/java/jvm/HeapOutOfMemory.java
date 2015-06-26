package org.txazo.java.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * HeapOutOfMemory
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 25.06.2015
 */
public class HeapOutOfMemory {

    /**
     * VM Args: -server -Xmx20M -Xms20M -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintCommandLineFlags
     */
    public static void main(String[] args) {
        List<byte[]> bytes = new ArrayList<byte[]>();
        for (int i = 0; i < 30; i++) {
            bytes.add(new byte[1024 * 1024]);
        }
    }

}
