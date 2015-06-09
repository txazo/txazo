package org.txazo.weixin.develop.accesstoken;

/**
 * AccessTokenHolder
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public class AccessTokenHolder {

    private static final int REPEAT_COUNT = 3;
    private static final int REPEAT_WAIT_TIME = 2000;
    private static final int REFRESH_WAIT_TIME = 5000;

    private static AccessTokenHolder instance = new AccessTokenHolder();

    private Object lock = new Object();
    private volatile AccessToken accessToken;

    private AccessTokenHolder() {
        Thread thread = new Thread(new AccessTokenRefreshThread());
        thread.setDaemon(true);
        thread.start();
    }

    public static AccessTokenHolder getInstance() {
        return instance;
    }

    public String getAccessToken() {
        if (accessToken == null) {
            synchronized (lock) {
                int repeatCount = REPEAT_COUNT;
                if (accessToken == null && repeatCount > 0) {
                    try {
                        Thread.sleep(REPEAT_WAIT_TIME);
                    } catch (InterruptedException e) {
                    } finally {
                        repeatCount--;
                    }
                }
            }
        }
        return accessToken == null ? null : accessToken.getAccess_token();
    }

    private class AccessTokenRefreshThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (accessToken == null || accessToken.isExpire()) {
                    try {
                        accessToken = AccessTokenUtils.requestAccessToken();
                    } catch (Throwable t) {
                    }
                }

                try {
                    Thread.sleep(REFRESH_WAIT_TIME);
                } catch (InterruptedException e) {
                }
            }
        }

    }

}
