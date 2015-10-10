package org.txazo.java.concurrency.base;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * AQS - 同步器
 * <pre>
 * 1) 同步状态: int state
 *      1) getState(): 获取当前同步状态
 *      2) setState(int): 设置同步状态
 *      3) compareAndSetState(int, int): CAS设置同步状态
 * 2) 内置FIFO队列
 * 3) 可重写的方法
 *      1) tryAcquire(int): 独占式获取同步状态
 *      2) tryRelease(int): 独占式释放同步状态
 *      3) tryAcquireShared(int): 共享式获取同步状态
 *      4) tryReleaseShared(int): 共享式释放同步状态
 *      5) isHeldExclusively: 是否被当前线程独占
 * </pre>
 *
 * @author xiaozhou.tu
 * @date 2015-10-10
 * @see java.util.concurrent.locks.AbstractQueuedSynchronizer
 * @see java.util.concurrent.locks.AbstractQueuedSynchronizer#getState()
 * @see java.util.concurrent.locks.AbstractQueuedSynchronizer#setState(int)
 * @see java.util.concurrent.locks.AbstractQueuedSynchronizer#tryAcquire(int)
 * @see java.util.concurrent.locks.AbstractQueuedSynchronizer#tryRelease(int)
 * @see java.util.concurrent.locks.AbstractQueuedSynchronizer#tryAcquireShared(int)
 * @see java.util.concurrent.locks.AbstractQueuedSynchronizer#tryReleaseShared(int)
 * @see java.util.concurrent.locks.AbstractQueuedSynchronizer#isHeldExclusively()
 */
public class AQSTest {

    /**
     * 自定义独占锁
     */
    private static class Mutex implements Lock {

        private static class Sync extends AbstractQueuedSynchronizer {

            @Override
            protected boolean tryAcquire(int arg) {
                if (compareAndSetState(0, 1)) {
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
                return false;
            }

            @Override
            protected boolean tryRelease(int arg) {
                if (getState() == 0) throw new IllegalMonitorStateException();
                setExclusiveOwnerThread(null);
                setState(0);
                return true;
            }

            @Override
            protected boolean isHeldExclusively() {
                return getState() == 1;
            }

            Condition newCondition() {
                return new ConditionObject();
            }

        }

        private final Sync sync = new Sync();

        @Override
        public void lock() {
            sync.acquire(1);
        }

        @Override
        public boolean tryLock() {
            return sync.tryAcquire(1);
        }

        @Override
        public void unlock() {
            sync.release(1);
        }

        @Override
        public Condition newCondition() {
            return sync.newCondition();
        }

        public boolean isLocked() {
            return sync.isHeldExclusively();
        }

        public boolean hasQueuedThreads() {
            return sync.hasQueuedThreads();
        }

        @Override
        public void lockInterruptibly() throws InterruptedException {
            sync.acquireInterruptibly(1);
        }

        @Override
        public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
            return sync.tryAcquireNanos(1, unit.toNanos(time));
        }

    }

}
