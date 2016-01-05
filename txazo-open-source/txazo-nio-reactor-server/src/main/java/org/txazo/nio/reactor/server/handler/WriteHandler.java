package org.txazo.nio.reactor.server.handler;

import org.apache.log4j.Logger;
import org.txazo.nio.reactor.server.Dispatcher;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class WriteHandler extends AbstractHandler {

    private static final Logger logger = Logger.getLogger(WriteHandler.class);

    public WriteHandler(HandlerContext context, Dispatcher dispatcher) {
        super(context, dispatcher);
    }

    @Override
    public void run() {
        logger.info("write");
        SocketChannel socket = context.getSocket();
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.clear();
            buffer.put("success".getBytes());
            buffer.flip();
            while (buffer.hasRemaining()) {
                socket.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
