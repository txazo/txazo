package org.txazo.nio.reactor.server;

import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

public class Reactor extends ThreadLifecycle {

    protected Dispatcher dispatcher;
    protected Selector selector;
    private Set<SelectionKey> selectionKeys;

    public Reactor(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;

        try {
            selector = Selector.open();
        } catch (IOException e) {
            throw new RuntimeException("Reactor init failed", e);
        }
    }

    @Override
    protected void doRun() throws Exception {
        selector.select();
        selectionKeys = selector.selectedKeys();
        if (CollectionUtils.isNotEmpty(selectionKeys)) {
            for (Iterator<SelectionKey> iterator = selectionKeys.iterator(); iterator.hasNext(); ) {
                dispatcher.dispatch(iterator.next());
            }
            selectionKeys.clear();
        }
    }

}
