package org.txazo.java.concurrency.thread.pool;

public interface ThreadPool<Job extends Runnable> {

    public void execute(Job job);

    public void shutdown();

}
