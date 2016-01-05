package org.txazo.nio.reactor.server;

import org.apache.log4j.Logger;

import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Acceptor implements Runnable {

    private static final Logger logger = Logger.getLogger(Acceptor.class);

    private ServerSocketChannel server;
    private Dispatcher dispatcher;

    public Acceptor(ServerSocketChannel server, Dispatcher dispatcher) {
        this.server = server;
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {
        try {
            SocketChannel socket = server.accept();
            if (socket != null) {
                dispatcher.registerRead(socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
