package org.txazo.util.time;

import org.springframework.util.StopWatch;

/**
 * TimeWatch
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 31.07.2015
 */
public class TimeWatch {

    private StopWatch stopWatch;

    public TimeWatch() {
        stopWatch = new StopWatch();
    }

    public void watch(String taskName, TimeWatchTask task) throws Throwable {
        watch(taskName, 1, task);
    }

    public void watch(String taskName, int times, TimeWatchTask task) throws Throwable {
        if (times <= 0) {
            throw new IllegalArgumentException("times must > 0");
        }
        stopWatch.start(taskName);
        for (int i = 0; i < times; i++) {
            task.execute();
        }
        stopWatch.stop();
    }

    public void showTime() {
        System.out.println(stopWatch.prettyPrint());
    }

}
