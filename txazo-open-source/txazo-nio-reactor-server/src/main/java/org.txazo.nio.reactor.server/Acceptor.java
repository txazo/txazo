package org.txazo.nio.reactor.server;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Acceptor extends AbstractLifecycle {

    private final int maxConnections;
    private volatile int connections = 0;
    private Deque connectionDeque = new ConcurrentLinkedDeque<>();
    private List<SubReactor> subReactors;

    public Acceptor(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    @Override
    public void doRun() throws Exception {
        for (SubReactor subReactor : subReactors) {
            subReactor.register(null, 0);
        }
    }

    public void accept(ServerSocketChannel server, SelectionKey selectionKey) {
        if (connections > maxConnections) {
            return;
        }

        try {
            if (selectionKey.isAcceptable()) {
                SocketChannel socket = server.accept();
                if (socket != null) {
                    connections++;
                    connectionDeque.addLast(socket);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dispatchSocket() {

    }

    public void setSubReactors(List<SubReactor> subReactors) {
        this.subReactors = subReactors;
    }

}
