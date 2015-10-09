package org.txazo.java.concurrency.thread;

import org.junit.Test;

/**
 * JoinTest
 *
 * @author xiaozhou.tu
 * @date 2015-10-09
 */
public class JoinTest {

    @Test
    public void testJoin() throws InterruptedException {
        Thread t = new Thread(new JoinThread(), "Join");
        t.start();
        t.join();
    }

//    "main" prio=5 tid=0x00007fa846001800 nid=0x1303 in Object.wait() [0x0000000106bbc000]
//    java.lang.Thread.State: WAITING (on object monitor)

    @Test
    public void testJoinTime() throws InterruptedException {
        Thread t = new Thread(new JoinThread(), "Join Time");
        t.start();
        t.join(20000);
    }

//    "main" prio=5 tid=0x00007f8252802000 nid=0x1303 in Object.wait() [0x0000000102f6d000]
//    java.lang.Thread.State: TIMED_WAITING (on object monitor)

    private static class JoinThread implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
