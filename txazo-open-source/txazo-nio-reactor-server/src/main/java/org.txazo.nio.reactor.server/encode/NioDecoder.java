package org.txazo.nio.reactor.server.encode;

public class NioDecoder extends KeyHolder implements Decoder {

    @Override
    public byte[] decode(byte[] data) throws Exception {
        return AESUtils.decrypt(KEY, data);
    }

}
