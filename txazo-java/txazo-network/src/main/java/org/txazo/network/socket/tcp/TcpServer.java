package org.txazo.network.socket.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TcpServer
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 02.06.2015
 */
public class TcpServer {

    private transient boolean isRunning;
    private int port;
    private ServerSocket serverSocket;

    public TcpServer(int port) {
        this.isRunning = false;
        this.port = port;
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void start() {
        if (isRunning) {
            throw new RuntimeException("the server is already started");
        }
        isRunning = true;

        System.out.println("server start, listening on port: " + port);

        try {
            while (isRunning) {
                /** 监听连接 */
                Socket socket = serverSocket.accept();
                new Thread(new ServerThread(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        isRunning = false;
    }

    public static void main(String[] args) {
        new TcpServer(6666).start();
    }

}
