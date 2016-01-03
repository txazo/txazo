package org.txazo.nio.reactor.server.encode;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public abstract class KeyHolder {

    protected static byte[] KEY;

    private static final String TEXT = "45a9b41a6ec61b9dfe7bd8ecea460f08";

    static {
        try {
            KEY = Hex.decodeHex(TEXT.toCharArray());
        } catch (DecoderException e) {
            throw new RuntimeException("KeyHolder init failed");
        }
    }

}
