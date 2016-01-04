package org.txazo.nio.reactor.server;

import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SubReactor extends AbstractLifecycle {

    private Selector selector;
    private Set<SelectionKey> selectionKeys;
    private ReadHandler readHandler;
    private WriteHandler writeHandler;
    private static Processor processor;

    public SubReactor() {
        try {
            selector = Selector.open();
            readHandler = new ReadHandler();
            writeHandler = new WriteHandler();
            processor = new NioProcessor();
        } catch (IOException e) {
            throw new RuntimeException("SubReactor init failed");
        }
    }

    @Override
    public void doRun() throws Exception {
        selector.select();
        selectionKeys = selector.selectedKeys();
        if (CollectionUtils.isNotEmpty(selectionKeys)) {
            for (Iterator<SelectionKey> iterator = selectionKeys.iterator(); iterator.hasNext(); ) {
                dispatch(iterator.next());
            }
            selectionKeys.clear();
        }
    }

    public void register(SocketChannel socket, int ops) throws IOException {
        socket.configureBlocking(false);
        socket.register(selector, ops, socket);
    }

    private void dispatch(SelectionKey selectionKey) {
        try {
            if (selectionKey.isReadable()) {
                readHandler.read(selectionKey);
            } else if (selectionKey.isWritable()) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
