package org.txazo.nio.reactor.server;

import java.util.ArrayList;
import java.util.List;

public class NioServer implements Lifecycle {

    private MainReactor mainReactor;
    private Acceptor acceptor;
    private List<SubReactor> subReactors = new ArrayList<SubReactor>();
    private List<Thread> subReactorThreads = new ArrayList<Thread>();

    public NioServer() {
        this(1000);
    }

    public NioServer(int maxConnections) {
        if (maxConnections <= 0) {
            throw new IllegalArgumentException("maxConnections must be greater than zero");
        }

        mainReactor = new MainReactor();
        acceptor = new Acceptor(maxConnections);
        for (int i = 0, length = Runtime.getRuntime().availableProcessors(); i < length; i++) {
            subReactors.add(new SubReactor());
        }

        mainReactor.setAcceptor(acceptor);
        acceptor.setSubReactors(subReactors);
    }

    @Override
    public void start() throws Exception {
        Thread mainThread = new Thread(mainReactor);
        mainThread.start();

        Thread acceptorThread = new Thread(acceptor);
        acceptorThread.start();

        for (SubReactor subReactor : subReactors) {
            Thread subThread = new Thread(subReactor);
            subThread.start();
            subReactorThreads.add(subThread);
        }

        mainThread.join();
        acceptorThread.join();
        for (Thread subReactorThread : subReactorThreads) {
            subReactorThread.join();
        }
    }

    @Override
    public void stop() throws Exception {
        mainReactor.stop();
        acceptor.stop();
        for (SubReactor subReactor : subReactors) {
            subReactor.stop();
        }
    }

}
