package org.txazo.nio.reactor.server;

public class NioServer {

    private MainReactor mainReactor;
    private SubReactor subReactor;
    private Acceptor acceptor;

    public NioServer() {
        mainReactor = new MainReactor();
        subReactor = new SubReactor();
        acceptor = new Acceptor(subReactor);

        mainReactor.setAcceptor(acceptor);
    }

    public void start() throws InterruptedException {
        Thread mainThread = new Thread(mainReactor);
        Thread subThread = new Thread(subReactor);

        mainThread.start();
        subThread.start();

        mainThread.join();
        subThread.join();
    }

    public void stop() {
        mainReactor.stop();
    }

}
