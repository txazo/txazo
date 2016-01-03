package org.txazo.nio.reactor.server;

import org.txazo.nio.reactor.server.exception.NioException;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SubReactor implements Runnable, Reactor {

    private Selector selector;
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
            throw new NioException("SubReactor init failed");
        }
    }

    @Override
    public void run() {
        Set<SelectionKey> selectionKeys = null;
        while (!Thread.interrupted()) {
            try {
                selector.select();
                selectionKeys = selector.selectedKeys();
                for (Iterator<SelectionKey> iterator = selectionKeys.iterator(); iterator.hasNext(); ) {
                    dispatch(iterator.next());
                }
                selectionKeys.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
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

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

}
