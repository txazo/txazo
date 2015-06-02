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
    private ServerSocket serverSocket;

    public TcpServer(int port) {
        this.isRunning = true;
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void start() {
        try {
            while (isRunning) {
                Socket socket = serverSocket.accept();
                new Thread(new ServerThread(socket)).start();
            }

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        isRunning = false;
    }

    public static void main(String[] args) {
        new TcpServer(6666).start();
    }

}
