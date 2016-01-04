package org.txazo.nio.reactor.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;

public class MainReactor extends Reactor {

    private ServerSocketChannel server;

    public MainReactor(int port, Dispatcher dispatcher) {
        super(dispatcher);

        if (port <= 0) {
            throw new IllegalArgumentException("port must be greater than zero");
        }

        try {
            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.socket().bind(new InetSocketAddress(port));
            server.register(selector, SelectionKey.OP_ACCEPT, new Acceptor(server, dispatcher));
        } catch (IOException e) {
            throw new RuntimeException("MainReactor init failed", e);
        }
    }

}
