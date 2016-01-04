package org.txazo.nio.reactor.server;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

public class SubReactor extends Reactor {

    private static final Logger logger = Logger.getLogger(SubReactor.class);

    private CountDownLatch count = new CountDownLatch(1);

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
        count.await();
        select();
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

    public void register(SocketChannel socket, int ops, Object attach) throws IOException {
        socket.configureBlocking(false);
        socket.register(selector, ops, attach);
        logger.info("register event");
        count.countDown();
    }

}
