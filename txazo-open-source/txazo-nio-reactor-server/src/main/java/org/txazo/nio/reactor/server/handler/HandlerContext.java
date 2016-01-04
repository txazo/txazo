package org.txazo.nio.reactor.server.handler;

import java.nio.channels.SocketChannel;

public class HandlerContext {

    private SocketChannel socket;

    public HandlerContext(SocketChannel socket) {
        this.socket = socket;
    }

    public SocketChannel getSocket() {
        return socket;
    }

    public void setSocket(SocketChannel socket) {
        this.socket = socket;
    }

}
