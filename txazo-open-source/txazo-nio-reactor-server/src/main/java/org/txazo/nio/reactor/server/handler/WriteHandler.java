package org.txazo.nio.reactor.server.handler;

import org.apache.log4j.Logger;
import org.txazo.nio.reactor.server.Dispatcher;

public class WriteHandler extends AbstractHandler {

    private static final Logger logger = Logger.getLogger(WriteHandler.class);

    public WriteHandler(HandlerContext context, Dispatcher dispatcher) {
        super(context, dispatcher);
    }

    @Override
    public void run() {
        logger.info("write");
    }

}
