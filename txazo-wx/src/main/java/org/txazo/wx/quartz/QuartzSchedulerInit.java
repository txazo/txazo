package org.txazo.wx.quartz;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * QuartzSchedulerInit
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 11.06.2015
 */
@Component
public class QuartzSchedulerInit {

    private List<Runnable> initThreads;

    public QuartzSchedulerInit() {
        System.out.println("----------QuartzSchedulerInit before");
        Thread thread = new Thread(new QuartzSchedulerInitThread());
        thread.setDaemon(true);
        thread.start();
        System.out.println("----------QuartzSchedulerInit after");
    }

    public List<Runnable> getInitThreads() {
        return initThreads;
    }

    public void setInitThreads(List<Runnable> initThreads) {
        this.initThreads = initThreads;
    }

    private class QuartzSchedulerInitThread implements Runnable {

        @Override
        public void run() {
            int repeatCount = 100;
            try {
                Thread.sleep(5000);
                while (CollectionUtils.isEmpty(initThreads) && repeatCount-- > 0) {
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
            }

            if (CollectionUtils.isNotEmpty(initThreads)) {
                for (Runnable runnable : initThreads) {
                    try {
                        System.out.println("----------QuartzSchedulerInit thread start");
                        new Thread(runnable).start();
                    } catch (Throwable t) {
                    }
                }
            }
        }

    }

}
