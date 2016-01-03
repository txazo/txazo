package org.txazo.nio.reactor.server.encode;

public class NioEncoder extends KeyHolder implements Encoder {

    @Override
    public byte[] encode(byte[] data) throws Exception {
        return AESUtils.encrypt(KEY, data);
    }

}
