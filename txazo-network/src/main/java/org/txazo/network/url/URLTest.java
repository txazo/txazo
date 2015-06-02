package org.txazo.network.url;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.txazo.log.LoggerUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * URLTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @see java.net.URL
 * @since 02.06.2015
 */
public class URLTest {

    @Test
    public void test1() throws MalformedURLException {
        /** protocol: http https */
        URL url = new URL("http://pe.txazo.com/");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                LoggerUtils.log(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(br);
        }
    }

    @Test
    public void test2() throws MalformedURLException {
        /** protocol: file */
        URL url = this.getClass().getResource("URLTest.class");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                LoggerUtils.log(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(br);
        }
    }

}
