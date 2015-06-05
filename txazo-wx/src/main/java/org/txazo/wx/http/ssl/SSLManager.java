package org.txazo.wx.http.ssl;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import java.security.KeyStore;

/**
 * SSLManager
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 04.06.2015
 */
public abstract class SSLManager {

    private static final String keyStoreFile = "/weixin.keystore";

    public static SSLConnectionSocketFactory buildSSLSocketFactory() {
        SSLContext sslContext = null;
        try {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(SSLManager.class.getResourceAsStream(keyStoreFile), "123456".toCharArray());
            sslContext = SSLContexts.custom().loadTrustMaterial(keyStore, new TrustSelfSignedStrategy()).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new SSLConnectionSocketFactory(sslContext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());
    }

}
