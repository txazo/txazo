package org.txazo.nio.reactor.server;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Set;

public abstract class Reactor extends ThreadLifecycle {

    protected final Dispatcher dispatcher;
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
