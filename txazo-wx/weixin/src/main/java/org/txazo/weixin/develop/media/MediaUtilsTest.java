package org.txazo.weixin.develop.media;

import org.txazo.log.LoggerUtils;

public class MediaUtilsTest {

    public static void main(String[] args) throws Exception {
        LoggerUtils.log(MediaUtils.getMediaId("classpath:images/agent_0.jpg"));
        LoggerUtils.log(MediaUtils.getMediaId("classpath:images/agent_0.jpg"));
        System.exit(0);
    }

}
