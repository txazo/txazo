package org.txazo.nio.reactor.server;

public abstract class ThreadLifecycle implements Runnable, Lifecycle {

    private volatile boolean running = true;

    @Override
    public void run() {
        while (running && !Thread.interrupted()) {
            try {
                doRun();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected abstract void doRun() throws Exception;

    @Override
    public void start() throws Exception {
    }

    @Override
    public void stop() throws Exception {
        running = false;
    }

}
