package org.txazo.nio.reactor.server.encode;

public interface Decoder {

    public byte[] decode(byte[] data) throws Exception;

}
