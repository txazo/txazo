package org.txazo.security.key;

import java.security.*;

/**
 * KeyBuilder
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 18.06.2015
 */
public abstract class KeyBuilder {

    private static final int DEFAULT_KEY_SIZE = 1024;

    public static Key buildKey(String algorithm) throws NoSuchAlgorithmException {
        return buildKey(algorithm, DEFAULT_KEY_SIZE);
    }

    public static Key buildKey(String algorithm, int keySize) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        keyPairGenerator.initialize(keySize);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return new Key(keyPair.getPublic(), keyPair.getPrivate());
    }

}
