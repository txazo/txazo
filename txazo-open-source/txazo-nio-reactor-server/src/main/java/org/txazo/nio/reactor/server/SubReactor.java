package org.txazo.nio.reactor.server;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class SubReactor extends Reactor {

    private static final Logger logger = Logger.getLogger(SubReactor.class);

    public SubReactor(Dispatcher dispatcher) {
        super(dispatcher);

        try {
            selector = Selector.open();
        } catch (IOException e) {
            throw new RuntimeException("SubReactor init failed", e);
        }
    }

    public void register(SocketChannel socket, int ops, Object attach) throws IOException {
        if (!selecting) {
            selector.wakeup();
        }
        socket.configureBlocking(false);
        socket.register(selector, ops, attach);
        logger.info("register event");
    }

}
