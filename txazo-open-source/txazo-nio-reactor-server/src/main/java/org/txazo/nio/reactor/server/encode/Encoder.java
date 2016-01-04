package org.txazo.nio.reactor.server.encode;

public interface Encoder {

    public byte[] encode(byte[] data) throws Exception;

}
