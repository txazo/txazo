package org.txazo.nio.reactor.server;

public interface Processor {

    public void process(Request request, Response response);

}
