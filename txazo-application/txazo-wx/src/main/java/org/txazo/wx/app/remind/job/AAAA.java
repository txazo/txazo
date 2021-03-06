package org.txazo.wx.app.remind.job;

import org.quartz.*;
import org.txazo.util.schedule.quartz.DefaultQuartzScheduler;
import org.txazo.util.schedule.quartz.QuartzScheduler;
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
            final QuartzScheduler quartzScheduler = new DefaultQuartzScheduler(scheduler);

            int id = 1;
            JobDetail jobDetail = JobBuilder.newJobDetail(String.valueOf(id), RemindJob.class, new JobData<Remind>(new Remind(id)), new JobCallback<Remind>() {

                @Override
                public void callback(Remind remind) {
                    System.out.println("JobCallback callback id " + remind.getId());
                }

            });
            Trigger trigger = TriggerBuilder.newCronTrigger("*/5 * * * * ?", KeyBuilder.newTriggerKey(String.valueOf(id), RemindJob.class));
            quartzScheduler.addSchedule(jobDetail, trigger);

            id = 2;
            jobDetail = JobBuilder.newJobDetail(String.valueOf(id), RemindJob.class, new JobData<Remind>(new Remind(id)), new JobCallback<Remind>() {

                @Override
                public void callback(Remind remind) {
                    System.out.println("JobCallback callback id " + remind.getId());
                }

            });
            trigger = TriggerBuilder.newCronTrigger("*/5 * * * * ?", KeyBuilder.newTriggerKey(String.valueOf(id), RemindJob.class));
            quartzScheduler.addSchedule(jobDetail, trigger);

//            new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(5000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("---------- deleteSchedule");
//                    quartzScheduler.deleteSchedule(KeyBuilder.newJobKey("1", RemindJob.class));
//                }
//
//            }).start();

//            new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(10000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("---------- deleteSchedule");
//                    quartzScheduler.deleteSchedule(KeyBuilder.newTriggerKey("2", RemindJob.class));
//                }
//
//            }).start();

//            new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    try {
//                        Thread.sleep(11000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("---------- update");
//                    Remind remind = new Remind();
//                    remind.setId(12);
//                    quartzScheduler.updateSchedule(JobBuilder.newJobDetail("1", RemindJob.class, new JobData<Remind>(remind), new JobCallback<Remind>() {
//
//                        @Override
//                        public void callback(Remind remind) {
//                            System.out.println("new JobCallback callback id " + remind.getId());
//                        }
//
//                    }));
//                }
//
//            }).start();

            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("---------- update");
                    TriggerKey triggerKey = KeyBuilder.newTriggerKey("1", RemindJob.class);
                    Trigger trigger = TriggerBuilder.newCronTrigger("* * * * * ?", triggerKey);
                    quartzScheduler.updateSchedule(triggerKey, trigger);
                }

            }).start();

            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
