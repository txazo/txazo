package org.txazo.tool.ftp;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FTPUpload {

    private FTPClient ftpClient;

    public FTPUpload() {
        ftpClient = new FTPClient();
    }

    /**
     * 连接
     *
     * @param account
     * @return
     * @throws java.io.IOException
     */
    public boolean connect(FTPAccount account) throws IOException {
        ftpClient.connect(account.getIp(), account.getPort());
        ftpClient.login(account.getUserName(), account.getPassword());
        int replyCode = ftpClient.getReplyCode();
        if (!FTPReply.isPositiveCompletion(replyCode)) {
            ftpClient.disconnect();
            return false;
        }
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
        return true;
    }

    /**
     * 上传文件
     *
     * @param content 内容
     * @param path    目录
     * @param output  文件名
     * @return
     * @throws Exception
     */
    public boolean uploadFile(byte[] data, String path, String output) throws Exception {
        InputStream input = null;
        try {
            if (ftpClient.changeWorkingDirectory(path)) {
                input = new ByteArrayInputStream(data);
                return ftpClient.storeFile(output, input);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            IOUtils.closeQuietly(input);
        }
        return false;
    }

    /**
     * 上传文件
     *
     * @param input  内容
     * @param path   目录
     * @param output 文件名
     * @return
     * @throws Exception
     */
    public boolean uploadFile(InputStream input, String path, String output) throws Exception {
        try {
            if (ftpClient.changeWorkingDirectory(path)) {
                return ftpClient.storeFile(output, input);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            IOUtils.closeQuietly(input);
        }
        return false;
    }

    /**
     * 复制远程文件
     *
     * @param path 目录
     * @param from 源文件
     * @param to   目标文件
     * @return
     * @throws Exception
     */
    public boolean copyRemoteFile(String path, String from, String to) throws Exception {
        ByteArrayInputStream bais = null;
        ByteArrayOutputStream baos = null;
        try {
            if (ftpClient.changeWorkingDirectory(path)) {
                baos = new ByteArrayOutputStream();
                if (ftpClient.retrieveFile(from, baos)) {
                    bais = new ByteArrayInputStream(baos.toByteArray());
                    return ftpClient.storeFile(to, bais);
                }
            }
        } catch (Exception e) {
            throw e;
        } finally {
            IOUtils.closeQuietly(bais);
            IOUtils.closeQuietly(baos);
        }
        return false;
    }

    /**
     * 重命名文件
     *
     * @param path    目录
     * @param oldName 老文件名
     * @param newName 新文件名
     * @return
     * @throws java.io.IOException
     */
    public boolean rename(String path, String oldName, String newName) throws IOException {
        if (ftpClient.changeWorkingDirectory(path)) {
            return ftpClient.rename(oldName, newName);
        }
        return false;
    }

    /**
     * 重命名文件
     *
     * @param oldName 老文件名
     * @param newName 新文件名
     * @return
     * @throws java.io.IOException
     */
    public boolean rename(String oldName, String newName) throws IOException {
        return ftpClient.rename(oldName, newName);
    }

    /**
     * 关闭连接
     */
    public void close() {
        try {
            ftpClient.logout();
            if (ftpClient.isConnected()) {
                ftpClient.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
