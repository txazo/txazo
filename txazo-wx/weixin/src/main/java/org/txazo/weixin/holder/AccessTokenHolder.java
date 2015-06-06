package org.txazo.weixin.holder;

import org.txazo.log.LoggerUtils;
import org.txazo.weixin.WeiXinUtils;
import org.txazo.weixin.bean.AccessToken;

/**
 * AccessTokenHolder
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public class AccessTokenHolder {

    private static AccessTokenHolder instance = new AccessTokenHolder();

    private volatile AccessToken accessToken;

    private AccessTokenHolder() {
        Thread thread = new Thread(new AccessTokenThread());
        thread.setDaemon(true);
        thread.start();
    }

    public static AccessTokenHolder getInstance() {
        return instance;
    }

    public String getAccessToken() {
        return accessToken == null ? null : accessToken.getAccess_token();
    }

    private class AccessTokenThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (accessToken == null || accessToken.isExpire()) {
                    accessToken = WeiXinUtils.getAccessToken();
                }

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    LoggerUtils.log(e);
                }
            }
        }

    }

}
