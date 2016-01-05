package org.txazo.nio.reactor.server.handler;

import org.apache.log4j.Logger;
import org.txazo.nio.reactor.server.Dispatcher;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ReadHandler extends AbstractHandler {

    private static final Logger logger = Logger.getLogger(ReadHandler.class);

    public ReadHandler(HandlerContext context, Dispatcher dispatcher) {
        super(context, dispatcher);
    }

    @Override
    public void run() {
        try {
            read();
            dispatcher.registerWrite(context.getSocket());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void read() throws IOException {
        SocketChannel socket = context.getSocket();
        logger.info(((InetSocketAddress) socket.getRemoteAddress()).getHostName());
        int length = -1;
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while ((length = socket.read(buffer)) > 0) {
            buffer.flip();
            // logger.info(new String(buffer.array(), 0, length));
            buffer.clear();
        }
    }

}
