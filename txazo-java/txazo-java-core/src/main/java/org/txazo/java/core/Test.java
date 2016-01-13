package org.txazo.java.core;

import java.io.IOException;

public class Test {

    public static void test1() throws Exception {
        throw new IOException("txazo");
    }

    public static void test2() throws Exception {
        test1();
    }

    public static void test3() throws Exception {
        test2();
    }

    public static void main(String[] args) {
        try {
            test3();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
