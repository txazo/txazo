package org.txazo.nio.reactor.server;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.log4j.Logger;
import org.txazo.nio.reactor.server.handler.HandlerContext;
import org.txazo.nio.reactor.server.handler.ReadHandler;
import org.txazo.nio.reactor.server.handler.WriteHandler;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedDeque;

public class SubReactor extends Reactor {

    private static final Logger logger = Logger.getLogger(SubReactor.class);

    private volatile boolean selectBlocking = false;
    private Runnable r;
    private ChannelRegisterTask task;
    private SelectionKey selectionKey;
    private Deque<ChannelRegisterTask> socketChannelDeque = new ConcurrentLinkedDeque<ChannelRegisterTask>();

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
        registerChannel();
        select();
    }

    public void registerRead(SocketChannel socket) throws IOException {
        register(socket, SelectionKey.OP_READ);
    }

    public void registerWrite(SocketChannel socket) throws IOException {
        register(socket, SelectionKey.OP_WRITE);
    }

    public void register(SocketChannel socket, int ops) throws IOException {
        socketChannelDeque.offerFirst(new ChannelRegisterTask(socket, ops));
        if (selectBlocking) {
            selector.wakeup();
        }
    }

    public void registerChannel() throws IOException {
        while ((task = socketChannelDeque.pollLast()) != null) {
            registerChannel(task.getSocket(), task.getOps());
        }
    }

    public void registerChannel(SocketChannel socket, int ops) throws IOException {
        if (ops == SelectionKey.OP_READ) {
            socket.configureBlocking(false);
            socket.register(selector, ops, new ReadHandler(new HandlerContext(socket), dispatcher));
        } else if (ops == SelectionKey.OP_WRITE) {
            socket.configureBlocking(false);
            socket.register(selector, ops, new WriteHandler(new HandlerContext(socket), dispatcher));
        } else {
            throw new IllegalArgumentException("ops is invalid");
        }
    }

    protected void select() throws Exception {
        selectBlocking = true;
        selector.select();
        selectBlocking = false;
        selectionKeys = selector.selectedKeys();
        if (CollectionUtils.isNotEmpty(selectionKeys)) {
            for (Iterator<SelectionKey> iterator = selectionKeys.iterator(); iterator.hasNext(); ) {
                selectionKey = iterator.next();
                r = (Runnable) selectionKey.attachment();
                selectionKey.cancel();
                dispatcher.dispatch(r);
            }
            selectionKeys.clear();
        }
    }

    private static class ChannelRegisterTask {

        private SocketChannel socket;
        private int ops;

        public ChannelRegisterTask(SocketChannel socket, int ops) {
            this.socket = socket;
            this.ops = ops;
        }

        public SocketChannel getSocket() {
            return socket;
        }

        public int getOps() {
            return ops;
        }

    }

}
