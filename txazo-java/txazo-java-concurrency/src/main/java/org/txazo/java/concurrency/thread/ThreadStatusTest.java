package org.txazo.java.concurrency.thread;

/**
 * ThreadStatusTest
 *
 * @author xiaozhou.tu
 * @date 2015-10-09
 */
public class ThreadStatusTest {

    /**
     * 线程状态
     *
     * 1) NEW
     * 2) RUNNABLE
     * 3) BLOCKED: 等待对象锁
     *    1) synchronized
     * 4) WAITING: 等待其它线程唤醒
     *    1) Object.wait()
     *    2) Thread.join()
     *    3) LockSupport.park()
     * 5) TIMED_WAITING: 指定时间内等待其它线程唤醒
     *    1) Thread.sleep(timeout)
     *    2) Object.wait(timeout)
     *    3) Thread.join(timeout)
     *    4) LockSupport.parkNanos(timeout)
     *    5) LockSupport.parkUntil(timeout)
     * 6) TERMINATED
     */

//    runnable
//    java.lang.Thread.State: RUNNABLE

//    waiting on condition
//    java.lang.Thread.State: RUNNABLE

//    waiting for monitor entry
//    java.lang.Thread.State: BLOCKED (on object monitor)

//    in Object.wait()
//    java.lang.Thread.State: WAITING (on object monitor)

//    waiting on condition
//    java.lang.Thread.State: WAITING (parking)

//    waiting on condition
//    java.lang.Thread.State: TIMED_WAITING (sleeping)

//    in Object.wait()
//    java.lang.Thread.State: TIMED_WAITING (on object monitor)

//    waiting on condition
//    java.lang.Thread.State: TIMED_WAITING (parking)

}
