package org.txazo.tool.ftp;

public class FTPAccount {

    private String ip;
    private int port;
    private String userName;
    private String password;

    public FTPAccount(String ip, int port, String userName, String password) {
        this.ip = ip;
        this.port = port;
        this.userName = userName;
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}
