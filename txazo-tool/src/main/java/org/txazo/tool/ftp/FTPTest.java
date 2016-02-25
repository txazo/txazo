package org.txazo.tool.ftp;

import org.junit.Test;

public class FTPTest {

    @Test
    public void test() {
        FTPUpload ftp = new FTPUpload();
        try {
            if (ftp.connect(FTPUtils.ACCOUNT)) {
                ftp.rename("/test", "oldname", "newname");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ftp.close();
        }
    }

}
