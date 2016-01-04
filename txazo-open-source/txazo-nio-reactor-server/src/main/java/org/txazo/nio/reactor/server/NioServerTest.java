package org.txazo.nio.reactor.server;

public class NioServerTest {

    public static void main(String[] args) {
        try {
            new NioServer().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
