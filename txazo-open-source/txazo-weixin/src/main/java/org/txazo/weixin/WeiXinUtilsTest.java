package org.txazo.weixin;

import org.junit.Test;
import org.txazo.log.LoggerUtils;
import org.txazo.weixin.develop.media.MediaUtils;
import org.txazo.weixin.develop.message.MPNewsMessage;
import org.txazo.weixin.develop.message.MessageBuilder;
import org.txazo.weixin.develop.message.NewsMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * WeiXinUtilsTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public class WeiXinUtilsTest {

    @Test
    public void testGetAccessToken() {
        LoggerUtils.log(WeiXinUtils.getAccessToken());
        LoggerUtils.log(WeiXinUtils.getAccessToken());
    }

    @Test
    public void testGetMediaId() {
        LoggerUtils.log(WeiXinUtils.getMediaId("classpath:images/agent_0.jpg"));
        LoggerUtils.log(WeiXinUtils.getMediaId("classpath:images/agent_0.jpg"));
    }

    @Test
    public void testVerifyURL() {
        LoggerUtils.log(WeiXinUtils.verifyURL("f3feadae32dc8e39ec465e9dbd28daaf1e99f027", "1433914969", "1725123544", "tBvUFIm73NqScxncEM7aVTwJu9Rx4RTrBAAvyX4Ll8aCYS6KOg+7m9gynKyoeac3YBGLcDEioCqtLBQNXE0hQA=="));
    }

    @Test
    public void testSendTextMessage() {
        LoggerUtils.log(WeiXinUtils.sendMessage(MessageBuilder.buildTextMessage("txazo1218", null, null, "8", "0", "你好")));
    }

    @Test
    public void testSendImageMessage() {
        String mediaId = WeiXinUtils.getMediaId("classpath:images/agent_8.jpg");
        LoggerUtils.log(WeiXinUtils.sendMessage(MessageBuilder.buildImageMessage("txazo1218", null, null, "8", "0", mediaId)));
    }

    @Test
    public void sendNewsMessage() {
        NewsMessage.Article article = new NewsMessage.Article("txazo", "txazo开发社区", "http://wx.txazo.com", "https://ss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/super/whfpf%3D425%2C260%2C50/sign=7cb3d0a4d71b0ef46cbdcb1ebbf965e8/8435e5dde71190efaeb70a55cb1b9d16fcfa60e8.jpg");
        List<NewsMessage.Article> articles = new ArrayList<NewsMessage.Article>();
        articles.add(article);
        articles.add(new NewsMessage.Article("txazo1", "txazo开发社区1", "http://wx.txazo.com", "https://ss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/super/whfpf%3D425%2C260%2C50/sign=7cb3d0a4d71b0ef46cbdcb1ebbf965e8/8435e5dde71190efaeb70a55cb1b9d16fcfa60e8.jpg"));
        articles.add(new NewsMessage.Article("txazo2", "txazo开发社区2", "http://wx.txazo.com", "https://ss0.baidu.com/94o3dSag_xI4khGko9WTAnF6hhy/super/whfpf%3D425%2C260%2C50/sign=7cb3d0a4d71b0ef46cbdcb1ebbf965e8/8435e5dde71190efaeb70a55cb1b9d16fcfa60e8.jpg"));
        LoggerUtils.log(WeiXinUtils.sendMessage(MessageBuilder.buildNewsMessage("txazo1218", null, null, "8", "0", article)));
        LoggerUtils.log(WeiXinUtils.sendMessage(MessageBuilder.buildNewsMessage("txazo1218", null, null, "8", "0", articles)));
    }

    @Test
    public void sendMPNewsMessage() {
        MPNewsMessage.Article article = new MPNewsMessage.Article();
        article.setTitle("mpnews");
        article.setThumb_media_id(MediaUtils.getMediaId("classpath:images/1.jpg"));
        article.setAuthor("txazo");
        article.setContent_source_url("http://www.baidu.com/");
        article.setContent("你好好");
        article.setDigest("asasasasa");
        article.setShow_cover_pic("1");
        LoggerUtils.log(WeiXinUtils.sendMessage(MessageBuilder.buildMPNewsMessage("txazo1218", null, null, "8", "0", article)));
    }

}
