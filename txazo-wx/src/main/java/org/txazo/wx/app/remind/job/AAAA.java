package org.txazo.wx.app.remind.job;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.txazo.util.schedule.quartz.build.JobBuilder;
import org.txazo.util.schedule.quartz.build.KeyBuilder;
import org.txazo.util.schedule.quartz.build.TriggerBuilder;
import org.txazo.util.schedule.quartz.job.JobCallback;
import org.txazo.util.schedule.quartz.job.JobData;
import org.txazo.wx.app.remind.bean.Remind;

public class AAAA {

    public static void main(String[] args) {
        try {
            SchedulerFactory schedulerFactory = new org.quartz.impl.StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.start();

            JobDetail jobDetail = JobBuilder.newJobDetail("1", RemindJob.class, new JobData<Remind>(new Remind()), new JobCallback<Remind>() {

                @Override
                public void callback(Remind remind) {
                    System.out.println("JobCallback callback id " + remind.getId());
                }

            });

            Trigger trigger = TriggerBuilder.newCronTrigger("*/5 * * * * ?", KeyBuilder.newTriggerKey("1", RemindJob.class));

            scheduler.scheduleJob(jobDetail, trigger);

            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
