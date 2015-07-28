package org.txazo.util.time;

/**
 * ExecutionUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 28.07.2015
 */
public abstract class ExecutionUtils {

    public static void executeTime(String executionName, int times, Executor executor) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            executor.execute();
        }
        System.out.println(executionName + " execute " + (System.currentTimeMillis() - start) + " ms");
    }

}
