package org.txazo.wx.app.remind.execute;

import org.springframework.stereotype.Component;

/**
 * IndexController
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.06.2015
 */
@Component
public class RemindExecute {

    public RemindExecute() {
        Thread thread = new Thread(new RemindExecuteThread());
        thread.setDaemon(true);
        thread.start();
    }

    private class RemindExecuteThread implements Runnable {

        @Override
        public void run() {
        }

    }

}
