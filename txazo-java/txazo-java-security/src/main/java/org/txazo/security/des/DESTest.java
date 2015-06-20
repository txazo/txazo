package org.txazo.security.des;

import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;
import java.security.spec.KeySpec;

/**
 * DESTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 20.06.2015
 */
public class DESTest {

    private static final String DES = "DES";

    /** 明文 */
    private String plainText = "security des";
    /** 密文 */
    private String cipherText = "2f66f8400cd43ef7c34e8b217e1d773f";
    /** 密钥 */
    private String secretKey = "cbabe019ab9264a8";

    @Test
    public void testJdkDES() throws Exception {
        KeySpec keySpec = new DESKeySpec(Hex.decodeHex(secretKey.toCharArray()));
        SecretKeyFactory factory = SecretKeyFactory.getInstance(DES);
        Key key = factory.generateSecret(keySpec);
        Cipher cipher = Cipher.getInstance(DES);

        /** 加密 */
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptBytes = cipher.doFinal(plainText.getBytes());
        Assert.assertEquals(cipherText, Hex.encodeHexString(encryptBytes));

        /** 解密 */
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptBytes = cipher.doFinal(encryptBytes);
        Assert.assertEquals(plainText, new String(decryptBytes));
    }

}
