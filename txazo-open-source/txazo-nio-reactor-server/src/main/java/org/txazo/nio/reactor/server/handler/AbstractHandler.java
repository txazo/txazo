package org.txazo.nio.reactor.server.handler;

import org.txazo.nio.reactor.server.Dispatcher;

public abstract class AbstractHandler implements Handler {

    protected HandlerContext context;
    protected Dispatcher dispatcher;

    public AbstractHandler(HandlerContext context, Dispatcher dispatcher) {
        this.context = context;
        this.dispatcher = dispatcher;
    }

}
