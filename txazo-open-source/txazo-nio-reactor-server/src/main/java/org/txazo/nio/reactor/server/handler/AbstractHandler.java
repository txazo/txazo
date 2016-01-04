package org.txazo.nio.reactor.server.handler;

public abstract class AbstractHandler implements Handler {

    protected HandlerContext context;

    public AbstractHandler(HandlerContext context) {
        this.context = context;
    }

}
