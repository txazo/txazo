package org.txazo.nio.reactor.server;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;
import org.txazo.nio.reactor.server.handler.HandlerContext;
import org.txazo.nio.reactor.server.handler.ReadHandler;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CountDownLatch;

public class SubReactor extends Reactor {

    private static final Logger logger = Logger.getLogger(SubReactor.class);

    private CountDownLatch count = new CountDownLatch(1);

    private ConcurrentLinkedDeque<SocketChannel> deque = new ConcurrentLinkedDeque<SocketChannel>();

    public SubReactor(Dispatcher dispatcher) {
        super(dispatcher);

        try {
            selector = Selector.open();
        } catch (IOException e) {
            throw new RuntimeException("SubReactor init failed", e);
        }
    }

    @Override
    protected void doRun() throws Exception {
        register();
        select();
    }

    public void register() throws IOException {
        SocketChannel socket = null;
        while ((socket = deque.pollFirst()) != null) {
            socket.configureBlocking(false);
            socket.register(selector, SelectionKey.OP_READ, new ReadHandler(new HandlerContext(socket)));
            logger.info("register event");
        }
    }

    protected void select() throws Exception {
        selector.select();
        selectionKeys = selector.selectedKeys();
        if (CollectionUtils.isNotEmpty(selectionKeys)) {
            for (Iterator<SelectionKey> iterator = selectionKeys.iterator(); iterator.hasNext(); ) {
                logger.info("dispatch event");
                SelectionKey selectionKey = iterator.next();
                dispatcher.dispatch(selectionKey);
                selectionKey.cancel();
            }
            selectionKeys.clear();
        }
    }

    public void register(SocketChannel socket) throws IOException {
        deque.addLast(socket);
        selector.wakeup();
    }

}
