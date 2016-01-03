package org.txazo.nio.reactor.server;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Acceptor implements Runnable {

    private final int maxAcceptConnections;
    private volatile int acceptConnections = 0;
    private Deque acceptConnectionDeque = new ConcurrentLinkedDeque<>();
    private List<SubReactor> subReactors;

    public Acceptor(int maxAcceptConnections) {
        this.maxAcceptConnections = maxAcceptConnections;
    }

    @Override
    public void run() {
        while (true) {
            try {
                for (SubReactor subReactor : subReactors) {
                    subReactor.register(null, 0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void accept(ServerSocketChannel server, SelectionKey selectionKey) {
        if (acceptConnections > maxAcceptConnections) {
            return;
        }

        try {
            if (selectionKey.isAcceptable()) {
                SocketChannel socket = server.accept();
                if (socket != null) {
                    acceptConnections++;
                    acceptConnectionDeque.addLast(socket);
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
