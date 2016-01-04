package org.txazo.nio.reactor.server;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

public class Reactor extends ThreadLifecycle {

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

    @Override
    protected void doRun() throws Exception {
        select();
    }

    protected void select() throws Exception {
        selector.select();
        selectionKeys = selector.selectedKeys();
        if (CollectionUtils.isNotEmpty(selectionKeys)) {
            for (Iterator<SelectionKey> iterator = selectionKeys.iterator(); iterator.hasNext(); ) {
                logger.info("dispatch event");
                dispatcher.dispatch(iterator.next());
            }
            selectionKeys.clear();
        }
    }

}
