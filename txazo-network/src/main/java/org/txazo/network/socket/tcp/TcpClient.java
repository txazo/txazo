package org.txazo.network.socket.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * TcpClient
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 02.06.2015
 */
public class TcpClient {

    private transient boolean isRunning;
    private Socket socket;
    private BufferedReader input;
    private PrintStream output;

    public TcpClient() {
        this.isRunning = true;
    }

    public void connect(String host, int port) {
        try {
            /** 建立连接 */
            socket = new Socket(host, port);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
            output = new PrintStream(socket.getOutputStream(), true, "UTF-8");

            output.println("connect");

            /** 发送接受数据 */
            while (isRunning) {
                String data = input.readLine();
                System.out.println(data);
                if (data.equals("connect ok")) {
                    output.println("send");
                } else if (data.equals("reply")) {
                    output.println("close");
                } else if (data.equals("close ok")) {
                    isRunning = false;
                }
            }

            /** 关闭连接 */
            output.close();
            input.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    new TcpClient().connect("127.0.0.1", 6666);
                }

            }).start();
        }
    }

}
