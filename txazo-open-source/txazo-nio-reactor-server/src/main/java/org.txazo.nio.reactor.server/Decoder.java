package org.txazo.nio.reactor.server;

public interface Decoder {

    public byte[] decode(byte[] data);

}
