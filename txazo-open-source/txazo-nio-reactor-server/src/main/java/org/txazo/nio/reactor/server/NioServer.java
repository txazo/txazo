package org.txazo.nio.reactor.server;

import java.util.ArrayList;
import java.util.List;

public class NioServer implements Lifecycle {

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
    }

    @Override
    public void start() throws Exception {
        Thread mainThread = new Thread(mainReactor);
        mainThread.start();

        for (SubReactor subReactor : subReactors) {
            Thread subThread = new Thread(subReactor);
            subThread.start();
            subReactorThreads.add(subThread);
        }

        mainThread.join();
        for (Thread subReactorThread : subReactorThreads) {
            subReactorThread.join();
        }
    }

    @Override
    public void stop() throws Exception {
        mainReactor.stop();
        for (SubReactor subReactor : subReactors) {
            subReactor.stop();
        }
    }

}
