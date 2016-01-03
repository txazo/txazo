package org.txazo.nio.reactor.server;

public interface Lifecycle {

    public void start() throws Exception;

    public void stop() throws Exception;

}
