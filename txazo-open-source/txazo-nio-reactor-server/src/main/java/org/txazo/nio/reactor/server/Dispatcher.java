package org.txazo.nio.reactor.server;

import org.apache.log4j.Logger;

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
    private BlockingDeque<RegisterTask> registerTaskDeque = new LinkedBlockingDeque<RegisterTask>();

    public Dispatcher(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    @Override
    protected void doRun() throws Exception {
        for (SubReactor subReactor : subReactors) {
            registerTaskDeque.takeLast().register(subReactor);
        }
    }

    public void registerRead(SocketChannel socket) throws Exception {
        registerTaskDeque.putFirst(new RegisterTask(socket) {

            @Override
            public void register(SubReactor subReactor, SocketChannel socket) throws Exception {
                subReactor.registerRead(socket);
            }

        });
    }

    public void registerWrite(SocketChannel socket) throws Exception {
        registerTaskDeque.putFirst(new RegisterTask(socket) {

            @Override
            public void register(SubReactor subReactor, SocketChannel socket) throws Exception {
                subReactor.registerWrite(socket);
            }

        });
    }

    public void dispatch(Runnable r) {
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

    private abstract class RegisterTask {

        private SocketChannel socket;

        public RegisterTask(SocketChannel socket) {
            this.socket = socket;
        }

        public void register(SubReactor subReactor) throws Exception {
            register(subReactor, socket);
        }

        public abstract void register(SubReactor subReactor, SocketChannel socket) throws Exception;

    }

}
