package org.txazo.nio.reactor.server.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NioClientTest {

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        URL url = new URL("http://127.0.0.1:8090");

                        String params = "admin=root&password=root";
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setDoInput(true);
                        connection.setDoOutput(true);

                        connection.connect();

                        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String line = null;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                        br.close();

                        connection.disconnect();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }).start();
        }
    }

}
