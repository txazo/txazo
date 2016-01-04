package org.txazo.nio.reactor.server;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;

public class WriteHandler {

    public void write(SelectionKey selectionKey) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        selectionKey.channel();
    }

}
