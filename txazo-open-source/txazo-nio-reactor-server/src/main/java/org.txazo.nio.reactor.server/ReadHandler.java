package org.txazo.nio.reactor.server;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public class ReadHandler {

    public void read(SelectionKey selectionKey) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        SocketChannel socket = (SocketChannel) selectionKey.attachment();

        int length = -1;
        ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
        while ((length = socket.read(buffer)) != -1) {
            buffer.flip();
            baos.write(buffer.array(), 0, length);
            buffer.clear();
        }

        socket.configureBlocking(false);
    }

}
