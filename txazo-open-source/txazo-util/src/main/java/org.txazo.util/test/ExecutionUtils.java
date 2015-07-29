package org.txazo.util.test;

/**
 * ExecutionUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 28.07.2015
 */
public abstract class ExecutionUtils {

    public static void execute(String executionName, int times, Executor executor) {
        if (times <= 0) {
            throw new IllegalArgumentException("times must > 0");
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            executor.execute();
        }
        System.out.println(executionName + " execute " + (System.currentTimeMillis() - start) + " ms");
    }

}
