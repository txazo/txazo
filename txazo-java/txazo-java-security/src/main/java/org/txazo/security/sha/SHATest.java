package org.txazo.security.sha;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;

import java.security.MessageDigest;

/**
 * SHATest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 20.06.2015
 */
public class SHATest {

    /**
     * SHA应用
     * 1. SSL证书
     * 2. Open API(key + timestamp)
     */

    private static final String SHA1 = "SHA1";

    /** 明文 */
    private String plainText = "security sha1";
    private String sha1 = "528b6062db1e513304cc28bd5019e25a57a68b7c";

    @Test
    public void testJdkSHA1() throws Exception {
        MessageDigest md = MessageDigest.getInstance(SHA1);
        byte[] shaBytes = md.digest(plainText.getBytes());
        Assert.assertEquals(sha1, Hex.encodeHexString(shaBytes));
    }

    @Test
    public void testCodecSHA1() {
        Assert.assertEquals(sha1, DigestUtils.sha1Hex(plainText));
    }

}
