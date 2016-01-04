package org.txazo.nio.reactor.server;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class NioServer implements Lifecycle {

    private static final Logger logger = Logger.getLogger(NioServer.class);

    private Dispatcher dispatcher;
    private MainReactor mainReactor;
    private List<SubReactor> subReactors = new ArrayList<SubReactor>();
    private List<Thread> subReactorThreads = new ArrayList<Thread>();

    public NioServer() {
        this(8080, 1000);
    }

    public NioServer(int port, int maxConnections) {
        if (port <= 0) {
            throw new IllegalArgumentException("port must be greater than zero");
        }

        if (maxConnections <= 0) {
            throw new IllegalArgumentException("maxConnections must be greater than zero");
        }

        dispatcher = new Dispatcher(maxConnections);
        mainReactor = new MainReactor(port, dispatcher);
        for (int i = 0, length = Runtime.getRuntime().availableProcessors(); i < length; i++) {
            subReactors.add(new SubReactor(dispatcher));
        }

        dispatcher.setSubReactors(subReactors);
    }

    @Override
    public void start() throws Exception {
        Thread dispatcherThread = new Thread(dispatcher, "dispatcherThread");
        dispatcherThread.start();

        Thread mainReactorThread = new Thread(mainReactor, "mainReactorThread");
        mainReactorThread.start();

        for (int i = 0, length = subReactors.size(); i < length; i++) {
            Thread subReactorThread = new Thread(subReactors.get(i), "subReactorThread-" + i);
            subReactorThread.start();
            subReactorThreads.add(subReactorThread);
        }

        logger.info("NioServer start ...");

        dispatcherThread.join();
        mainReactorThread.join();
        for (Thread subReactorThread : subReactorThreads) {
            subReactorThread.join();
        }
    }

    @Override
    public void stop() throws Exception {
        dispatcher.stop();
        mainReactor.stop();
        for (SubReactor subReactor : subReactors) {
            subReactor.stop();
        }
    }

}
