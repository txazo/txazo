package org.txazo.nio.reactor.server.handler;

import org.apache.log4j.Logger;

public class ReadHandler extends AbstractHandler {

    private static final Logger logger = Logger.getLogger(ReadHandler.class);

    public ReadHandler(HandlerContext context) {
        super(context);
    }

    @Override
    public void run() {
        logger.info("run");
    }

}
