package org.txazo.nio.reactor.server;

import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class MainReactor extends AbstractLifecycle {

    private Selector selector;
    private ServerSocketChannel server;
    private Acceptor acceptor;
    private Set<SelectionKey> selectionKeys;

    public MainReactor() {
        try {
            selector = Selector.open();

            server = ServerSocketChannel.open();
            server.configureBlocking(false);
            server.socket().bind(new InetSocketAddress("127.0.0.1", 8080));
            server.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            throw new RuntimeException("MainReactor init failed");
        }
    }

    @Override
    public void doRun() throws Exception {
        selector.select();
        selectionKeys = selector.selectedKeys();
        if (CollectionUtils.isNotEmpty(selectionKeys)) {
            for (Iterator<SelectionKey> iterator = selectionKeys.iterator(); iterator.hasNext(); ) {
                acceptor.accept(server, iterator.next());
            }
            selectionKeys.clear();
        }
    }

    public void setAcceptor(Acceptor acceptor) {
        this.acceptor = acceptor;
    }

}
