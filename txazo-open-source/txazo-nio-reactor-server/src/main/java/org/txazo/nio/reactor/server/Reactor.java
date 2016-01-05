package org.txazo.nio.reactor.server;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Set;

public abstract class Reactor extends ThreadLifecycle {

    private static final Logger logger = Logger.getLogger(Reactor.class);

    protected Dispatcher dispatcher;
    protected Selector selector;
    protected Set<SelectionKey> selectionKeys;

    public Reactor(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;

        try {
            selector = Selector.open();
        } catch (IOException e) {
            throw new RuntimeException("Reactor init failed", e);
        }
    }

}
