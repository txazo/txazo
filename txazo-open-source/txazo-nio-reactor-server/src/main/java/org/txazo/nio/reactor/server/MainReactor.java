package org.txazo.nio.reactor.server;

import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class MainReactor extends Reactor {

    private ServerSocketChannel server;
    private Acceptor acceptor;

    public MainReactor(int port, Dispatcher dispatcher) {
        super(dispatcher);

        if (port <= 0) {
            throw new IllegalArgumentException("port must be greater than zero");
        }

        try {
            server = ServerSocketChannel.open();

            acceptor = new Acceptor(server, dispatcher);

            server.configureBlocking(false);
            server.socket().bind(new InetSocketAddress(port));
            server.register(selector, SelectionKey.OP_ACCEPT, acceptor);
        } catch (IOException e) {
            throw new RuntimeException("MainReactor init failed", e);
        }
    }

    @Override
    protected void doRun() throws Exception {
        selector.select();
        selectionKeys = selector.selectedKeys();
        if (CollectionUtils.isNotEmpty(selectionKeys)) {
            for (Iterator<SelectionKey> iterator = selectionKeys.iterator(); iterator.hasNext(); ) {
                dispatcher.dispatch((Runnable) iterator.next().attachment());
            }
            selectionKeys.clear();
        }
    }

}
