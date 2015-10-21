package org.txazo.java.concurrency.thread.pool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 简单的线程池
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {

    private final int size;
    private final LinkedList<Job> jobs = new LinkedList<Job>();
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());

    public DefaultThreadPool(int size) {
        this.size = size;
        initWorker();
    }

    private void initWorker() {
        /** 初始化工作线程 */
        for (int i = 0; i < size; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            new Thread(worker).start();
        }
    }

    @Override
    public void execute(Job job) {
        synchronized (jobs) {
            jobs.addLast(job);
            jobs.notify();
        }
    }

    @Override
    public void shutdown() {
        for (Worker worker : workers) {
            worker.shutdown();
        }
    }

    private class Worker implements Runnable {

        private volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                Job job = null;
                synchronized (jobs) {
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    job = jobs.removeFirst();
                }
                if (job != null) {
                    try {
                        job.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void shutdown() {
            running = false;
        }

    }

}
