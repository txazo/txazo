package org.txazo.nio.reactor.server;

import java.util.ArrayList;
import java.util.List;

public class NioServer implements Lifecycle {

    private MainReactor mainReactor;
    private Acceptor acceptor;

    private List<SubReactor> subReactors = new ArrayList<SubReactor>();
    private List<Thread> subReactorThreads = new ArrayList<Thread>();

    public NioServer() {
        mainReactor = new MainReactor();

        for (int i = 0, length = Runtime.getRuntime().availableProcessors(); i < length; i++) {
            subReactors.add(new SubReactor());
        }

        acceptor = new Acceptor(1000);

        mainReactor.setAcceptor(acceptor);

        acceptor.setSubReactors(subReactors);
    }

    @Override
    public void start() throws Exception {
        Thread mainThread = new Thread(mainReactor);
        mainThread.start();

        Thread acceptorThread = new Thread(acceptor);
        acceptorThread.start();

        for (int i = 0, length = subReactors.size(); i < length; i++) {
            Thread subThread = new Thread(subReactors.get(i));
            subThread.start();
            subReactorThreads.add(subThread);
        }

        mainThread.join();
        for (int i = 0, length = subReactorThreads.size(); i < length; i++) {
            subReactorThreads.get(i).join();
        }
    }

    @Override
    public void stop() throws Exception {
        mainReactor.stop();
    }

}
