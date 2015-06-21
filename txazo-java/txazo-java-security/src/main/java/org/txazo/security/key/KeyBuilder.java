package org.txazo.security.key;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
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

    public static byte[] buildSecretKey(String algorithm) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        keyGenerator.init(new SecureRandom());
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey.getEncoded();
    }

    public static String buildSecretKeyBase64String(String algorithm) throws NoSuchAlgorithmException {
        return Base64.encodeBase64String(buildSecretKey(algorithm));
    }

    public static String buildSecretKeyHexString(String algorithm) throws NoSuchAlgorithmException {
        return Hex.encodeHexString(buildSecretKey(algorithm));
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(buildSecretKeyHexString("HmacMD5"));
        System.out.println(buildSecretKeyHexString("DES"));
    }

}
