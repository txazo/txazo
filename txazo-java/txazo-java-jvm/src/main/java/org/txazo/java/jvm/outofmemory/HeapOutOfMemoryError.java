package org.txazo.java.jvm.outofmemory;

import java.util.ArrayList;
import java.util.List;

public class HeapOutOfMemoryError {

    /**
     * 堆内存溢出
     *
     * VM Args: -server -verbose:gc -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintCommandLineFlags
     *
     * java.lang.OutOfMemoryError: Java heap space
     */
    public static void main(String[] args) {
        List<byte[]> bytes = new ArrayList<byte[]>();
        for (int i = 0; i < 100; i++) {
            bytes.add(new byte[1024 * 1024]);
        }
    }

}
