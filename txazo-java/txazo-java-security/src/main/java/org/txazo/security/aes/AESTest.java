package org.txazo.security.aes;

import org.junit.Assert;
import org.junit.Test;

/**
 * AESTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 20.06.2015
 */
public class AESTest {

    /**
     * AES
     * 1. 对称加密
     */

    /** 明文 */
    private String plainText = "security aes";
    /** 密文 */
    private String cipherText = "8531986af683107bdcada26780f4ac19";
    /** 密钥 */
    private String secretKey = "45a9b41a6ec61b9dfe7bd8ecea460f08";

    @Test
    public void testAES() throws Exception {
        String encryptText = AESUtils.encryptHex(secretKey, plainText);
        Assert.assertEquals(cipherText, encryptText);
        String decryptText = AESUtils.decryptHex(secretKey, encryptText);
        Assert.assertEquals(plainText, decryptText);
    }

}
