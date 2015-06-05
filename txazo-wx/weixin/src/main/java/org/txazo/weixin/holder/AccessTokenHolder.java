package org.txazo.weixin.holder;

import org.txazo.weixin.bean.AccessToken;
import org.txazo.weixin.http.HttpClient;
import org.txazo.weixin.http.PoolHttpClient;

/**
 * AccessTokenHolder
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public class AccessTokenHolder {

    private AccessToken accessToken;
    private HttpClient httpClient = PoolHttpClient.getInstance();

    private static AccessTokenHolder instance;

    public static AccessTokenHolder getInstance() {
        if (instance == null) {
            synchronized (AccessTokenHolder.class) {
                if (instance == null) {
                    instance = new AccessTokenHolder();
                }
            }
        }
        return instance;
    }

    public String getAccessToken() {
        if (accessToken == null) {

        }
        return null;
    }

}
