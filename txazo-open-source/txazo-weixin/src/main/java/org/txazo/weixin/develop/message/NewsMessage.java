package org.txazo.weixin.develop.message;

import java.io.Serializable;
import java.util.List;

/**
 * NewsMessage
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.06.2015
 */
public class NewsMessage extends Message {

    private static final long serialVersionUID = -6489294881079705110L;

    private News news;

    public NewsMessage() {
        super("news");
    }

    public NewsMessage(String touser, String toparty, String totag, String agentid, String safe, News news) {
        super(touser, toparty, totag, "news", agentid, safe);
        this.news = news;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public static class News implements Serializable {

        private static final long serialVersionUID = -6236787798592789196L;

        private List<Article> articles;

        public News() {
        }

        public News(List<Article> articles) {
            this.articles = articles;
        }

        public List<Article> getArticles() {
            return articles;
        }

        public void setArticles(List<Article> articles) {
            this.articles = articles;
        }

    }

    public static class Article implements Serializable {

        private static final long serialVersionUID = -1220793594413061046L;

        /** 标题 */
        private String title;
        /** 描述 */
        private String description;
        /** 点击后的跳转链接 */
        private String url;
        /** 图文消息的图片链接 */
        private String picurl;

        public Article() {
        }

        public Article(String title, String description, String url, String picurl) {
            this.title = title;
            this.description = description;
            this.url = url;
            this.picurl = picurl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

    }

}
