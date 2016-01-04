package org.txazo.nio.reactor.server;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class SubReactor extends Reactor {

    private ReadHandler1 readHandler;
    private WriteHandler writeHandler;
    private static Processor processor;

    public SubReactor(Dispatcher dispatcher) {
        super(dispatcher);

        try {
            selector = Selector.open();
            readHandler = new ReadHandler1();
            writeHandler = new WriteHandler();
            processor = new NioProcessor();
        } catch (IOException e) {
            throw new RuntimeException("SubReactor init failed", e);
        }
    }

    public void register(SocketChannel socket, int ops, Object attach) throws IOException {
        socket.configureBlocking(false);
        socket.register(selector, ops, attach);
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
