package org.txazo.tool.rpc.future2;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class AsyncTaskTest {

    private static Service1 service1 = new Service1();
    private static Service2 service2 = new Service2();
    private static Service3 service3 = new Service3();

    public static void main(String[] args) {
        AsyncTask task = new AsyncTask();
        task.submit(TaskConfig.TASK_1, new Callable<String>() {

            @Override
            public String call() throws Exception {
                return service1.getName();
            }

        });
        task.submit(TaskConfig.TASK_2, new Callable<Boolean>() {

            @Override
            public Boolean call() throws Exception {
                Boolean exists = service2.exists();
                if (exists) {
                    task.submit(TaskConfig.TASK_3, new Callable<String>() {

                        @Override
                        public String call() throws Exception {
                            return service3.getResult();
                        }

                    });
                }
                return exists;
            }

        });

        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(task.getResult(TaskConfig.TASK_1, String.class));
        System.out.println(task.getResult(TaskConfig.TASK_2, Boolean.class));
        System.out.println(task.getResult(TaskConfig.TASK_3, String.class));
    }

    private static class Service1 {

        public String getName() {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "root";
        }

    }

    private static class Service2 {

        public boolean exists() {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }

    }

    private static class Service3 {

        public String getResult() {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "success";
        }

    }

}
