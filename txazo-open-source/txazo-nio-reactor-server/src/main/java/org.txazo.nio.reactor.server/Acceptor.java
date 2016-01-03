package org.txazo.nio.reactor.server;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Acceptor {

    private SubReactor subReactor;

    public Acceptor(SubReactor subReactor) {
        this.subReactor = subReactor;
    }

    public void accept(ServerSocketChannel server, SelectionKey selectionKey) {
        try {
            if (selectionKey.isAcceptable()) {
                SocketChannel socket = server.accept();
                if (socket != null) {
                    subReactor.register(socket, SelectionKey.OP_READ);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
