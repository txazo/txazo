package org.txazo.nio.reactor.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class MainReactor implements Runnable {

    private volatile boolean running = true;
    private Selector selector;
    private ServerSocketChannel server;
    private Acceptor acceptor;

    public MainReactor() {
        try {
            selector = Selector.open();

            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.socket().bind(new InetSocketAddress("127.0.0.1", 8080));
            server.register(selector, SelectionKey.OP_ACCEPT);

            acceptor = new Acceptor();
        } catch (IOException e) {
            throw new NioException("MainReactor init failed");
        }
    }

    @Override
    public void run() {
        Set<SelectionKey> selectionKeys = null;
        while (running || !Thread.interrupted()) {
            try {
                selector.select();
                selectionKeys = selector.selectedKeys();
                for (Iterator<SelectionKey> iterator = selectionKeys.iterator(); iterator.hasNext(); ) {
                    acceptor.accept(server, iterator.next());
                }
                selectionKeys.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        running = false;
    }

}
