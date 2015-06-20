package org.txazo.security.aes;

import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * AESTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 20.06.2015
 */
public class AESTest {

    private static final String AES = "AES";

    /** 明文 */
    private String plainText = "aes security";
    /** 密文 */
    private String cipherText = "84869f52dfd64d08793d76154d4636eb";
    /** 密钥 */
    private String secretKey = "435ea75d0168bc98";

    @Test
    public void testJdkAES() throws Exception {
        Key key = new SecretKeySpec(secretKey.getBytes(), AES);
        Cipher cipher = Cipher.getInstance(AES);

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
