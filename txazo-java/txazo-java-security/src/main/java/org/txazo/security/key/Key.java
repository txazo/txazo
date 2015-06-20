package org.txazo.security.key;

import org.apache.commons.codec.binary.Base64;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * Key
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 18.06.2015
 */
public class Key {

    private PublicKey publicKey;
    private PrivateKey privateKey;

    public Key(PublicKey publicKey, PrivateKey privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public String getPublic() {
        return Base64.encodeBase64String(publicKey.getEncoded());
    }

    public String getPrivate() {
        return Base64.encodeBase64String(privateKey.getEncoded());
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

}
