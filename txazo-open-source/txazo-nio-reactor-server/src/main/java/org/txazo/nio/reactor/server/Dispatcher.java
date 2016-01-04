package org.txazo.nio.reactor.server;

import org.apache.log4j.Logger;
import org.txazo.nio.reactor.server.handler.HandlerContext;
import org.txazo.nio.reactor.server.handler.ReadHandler;

import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher extends ThreadLifecycle {

    private static final Logger logger = Logger.getLogger(Dispatcher.class);

    private final int maxConnections;
    private AtomicInteger currentConnections = new AtomicInteger(0);
    private List<SubReactor> subReactors;
    private BlockingDeque<RegisterTask> taskDeque = new LinkedBlockingDeque<RegisterTask>();

    public Dispatcher(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    @Override
    protected void doRun() throws Exception {
        for (SubReactor subReactor : subReactors) {
            taskDeque.takeLast().register(subReactor);
        }
    }

    public void registerRead(SocketChannel socket) {
        try {
            logger.info("add RegisterTask read");
            taskDeque.putFirst(new RegisterTask(socket) {

                @Override
                public void register(SocketChannel socket, SubReactor subReactor) throws Exception {
                    subReactor.register(socket, SelectionKey.OP_READ, new ReadHandler(new HandlerContext(socket)));
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dispatch(SelectionKey selectionKey) {
        Runnable r = (Runnable) selectionKey.attachment();
        if (r != null) {
            r.run();
        }
    }

    private boolean checkFullCapacity() {
        return getConnections() >= maxConnections;
    }

    private int getConnections() {
        return currentConnections.get();
    }

    private void increaseConnection() {
        currentConnections.incrementAndGet();
    }

    private void decreaseConnection() {
        currentConnections.decrementAndGet();
    }

    public void setSubReactors(List<SubReactor> subReactors) {
        this.subReactors = subReactors;
    }

    private static abstract class RegisterTask {

        protected SocketChannel socket;

        public RegisterTask(SocketChannel socket) {
            this.socket = socket;
        }

        public void register(SubReactor subReactor) {
            try {
                register(socket, subReactor);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public abstract void register(SocketChannel socket, SubReactor subReactor) throws Exception;

    }

}
