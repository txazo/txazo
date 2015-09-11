package org.txazo.util.async;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * AsyncTask
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 2015-09-11
 */
public class AsyncTask {

    private static final ExecutorService taskPool = new ThreadPoolExecutor(50, 50, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(500));

    private Map<String, Future> futureMap = new HashMap<String, Future>();

    public <T> void submit(TaskConfig config, Callable<T> task) {
        futureMap.put(config.getId(), taskPool.submit(task));
    }

    public <T> T getResult(TaskConfig config, Class<T> clazz) {
        return getResult(config.getId(), config.getTimeout(), config.getDefaultResult(), clazz);
    }

    private <T> T getResult(String id, int timeout, Object defaultResult, Class<T> clazz) {
        Future future = futureMap.get(id);
        if (future != null) {
            try {
                return (T) future.get(timeout, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (T) defaultResult;
    }

}
