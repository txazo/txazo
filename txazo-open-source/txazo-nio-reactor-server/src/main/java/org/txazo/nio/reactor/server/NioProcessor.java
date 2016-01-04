package org.txazo.nio.reactor.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class NioProcessor implements Processor {

    private ExecutorService threadPool = new ThreadPoolExecutor(50, 50, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1000));

    @Override
    public void process(Request request, Response response) {

    }

}
