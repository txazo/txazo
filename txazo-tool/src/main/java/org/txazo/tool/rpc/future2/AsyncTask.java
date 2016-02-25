package org.txazo.tool.rpc.future2;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

public class AsyncTask {

    private static final ExecutorService taskPool = new ThreadPoolExecutor(50, 50, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(500));

    private Map<String, Future> futureMap = new HashMap<String, Future>();

    public <T> void submit(TaskConfig config, Callable<T> task) {
        futureMap.put(config.getId(), taskPool.submit(task));
    }

    private <T> T getResult(String id, Class<T> clazz) {
        return getResult(TaskConfig.getTaskConfig(id), clazz);
    }

    public <T> T getResult(TaskConfig config, Class<T> clazz) {
        if (config == null) {
            return null;
        }
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
