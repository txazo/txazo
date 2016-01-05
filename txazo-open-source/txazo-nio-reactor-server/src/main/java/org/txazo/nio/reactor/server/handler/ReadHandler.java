package org.txazo.nio.reactor.server.handler;

import org.apache.log4j.Logger;
import org.txazo.nio.reactor.server.Dispatcher;

public class ReadHandler extends AbstractHandler {

    private static final Logger logger = Logger.getLogger(ReadHandler.class);

    public ReadHandler(HandlerContext context, Dispatcher dispatcher) {
        super(context, dispatcher);
    }

    @Override
    public void run() {
        logger.info("read");
        try {
            dispatcher.registerWrite(context.getSocket());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
