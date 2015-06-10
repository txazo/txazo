package org.txazo.weixin.develop.message;

import java.util.ArrayList;
import java.util.List;

/**
 * MessageBuilder
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.06.2015
 */
public abstract class MessageBuilder {

    /**
     * 创建text消息
     *
     * @return
     */
    public static Message buildTextMessage(String touser, String toparty, String totag, String agentid, String safe, String content) {
        return new TextMessage(touser, toparty, totag, agentid, safe, new TextMessage.Text(content));
    }

    /**
     * 构建image消息
     *
     * @return
     */
    public static Message buildImageMessage(String touser, String toparty, String totag, String agentid, String safe, String media_id) {
        return new ImageMessage(touser, toparty, totag, agentid, safe, new ImageMessage.Image(media_id));
    }

    /**
     * 构建news消息
     *
     * @return
     */
    public static Message buildNewsMessage(String touser, String toparty, String totag, String agentid, String safe, List<NewsMessage.Article> articles) {
        return new NewsMessage(touser, toparty, totag, agentid, safe, new NewsMessage.News(articles));
    }

    /**
     * 构建news消息
     *
     * @return
     */
    public static Message buildNewsMessage(String touser, String toparty, String totag, String agentid, String safe, NewsMessage.Article article) {
        List<NewsMessage.Article> articles = new ArrayList<NewsMessage.Article>();
        articles.add(article);
        return buildNewsMessage(touser, toparty, totag, agentid, safe, articles);
    }

    /**
     * 构建mpnews消息
     *
     * @return
     */
    public static Message buildMPNewsMessage(String touser, String toparty, String totag, String agentid, String safe, List<MPNewsMessage.Article> articles) {
        return new MPNewsMessage(touser, toparty, totag, agentid, safe, new MPNewsMessage.MPNews(articles));
    }

    /**
     * 构建mpnews消息
     *
     * @return
     */
    public static Message buildMPNewsMessage(String touser, String toparty, String totag, String agentid, String safe, MPNewsMessage.Article article) {
        List<MPNewsMessage.Article> articles = new ArrayList<MPNewsMessage.Article>();
        articles.add(article);
        return new MPNewsMessage(touser, toparty, totag, agentid, safe, new MPNewsMessage.MPNews(articles));
    }

}
