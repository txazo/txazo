package org.txazo.nio.reactor.server;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioClientTest {

    private static Logger logger = Logger.getLogger(NioClientTest.class);
    private static ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            pool.submit(new Runnable() {

                @Override
                public void run() {
                    BufferedReader br = null;
                    try {
                        URL url = new URL("http://127.0.0.1:8090");
                        br = new BufferedReader(new InputStreamReader(url.openStream()));
                        String line = null;
                        while ((line = br.readLine()) != null) {
                            logger.info(line);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        IOUtils.closeQuietly(br);
                    }
                }

            });
        }

        Thread.sleep(1000000);
    }

}
