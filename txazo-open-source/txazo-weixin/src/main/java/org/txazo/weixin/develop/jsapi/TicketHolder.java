package org.txazo.weixin.develop.jsapi;

import org.apache.commons.lang3.StringUtils;

/**
 * TicketHolder
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 02.07.2015
 */
class TicketHolder {

    private static final int REPEAT_COUNT = 3;
    private static final int REPEAT_WAIT_TIME = 2000;
    private static final int REFRESH_WAIT_TIME = 5000;

    private static TicketHolder instance = new TicketHolder();

    private final Object lock = new Object();
    private volatile Ticket ticket;

    private TicketHolder() {
        Thread thread = new Thread(new TicketRefreshThread());
        thread.setDaemon(true);
        thread.start();
    }

    public static TicketHolder getInstance() {
        return instance;
    }

    public String getTicket() {
        if (ticket == null) {
            synchronized (lock) {
                int repeatCount = REPEAT_COUNT;
                while (ticket == null && repeatCount > 0) {
                    try {
                        Thread.sleep(REPEAT_WAIT_TIME);
                    } catch (InterruptedException e) {
                    } finally {
                        repeatCount--;
                    }
                }
            }
        }
        return ticket == null ? StringUtils.EMPTY : ticket.getTicket();
    }

    private class TicketRefreshThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (ticket == null || ticket.isExpire()) {
                    try {
                        ticket = JsApiUtils.requestTicket();
                        if (ticket != null && !ticket.success()) {
                            ticket = null;
                        }
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
