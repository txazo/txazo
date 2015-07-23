package org.txazo.weixin.develop.message;

import java.io.Serializable;
import java.util.List;

/**
 * MPNewsMessage
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 10.06.2015
 */
public class MPNewsMessage extends Message {

    private static final long serialVersionUID = -6217546219353558222L;

    private MPNews mpnews;

    public MPNewsMessage() {
        super("mpnews");
    }

    public MPNewsMessage(String touser, String toparty, String totag, String agentid, String safe, MPNews mpnews) {
        super(touser, toparty, totag, "mpnews", agentid, safe);
        this.mpnews = mpnews;
    }

    public MPNews getMpnews() {
        return mpnews;
    }

    public void setMpnews(MPNews mpnews) {
        this.mpnews = mpnews;
    }

    public static class MPNews implements Serializable {

        private static final long serialVersionUID = 8449831999138239975L;

        private List<Article> articles;

        public MPNews() {
        }

        public MPNews(List<Article> articles) {
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

        private static final long serialVersionUID = 1604670323488668032L;

        /** 图文消息的标题 */
        private String title;
        /** 图文消息缩略图的media_id */
        private String thumb_media_id;
        /** 图文消息的作者 */
        private String author;
        /** 图文消息点击“阅读原文”之后的页面链接 */
        private String content_source_url;
        /** 图文消息的内容，支持html标签 */
        private String content;
        /** 图文消息的描述 */
        private String digest;
        /** 是否显示封面，1为显示，0为不显示 */
        private String show_cover_pic;

        public Article() {
        }

        public Article(String title, String thumb_media_id, String author, String content_source_url, String content, String digest, String show_cover_pic) {
            this.title = title;
            this.thumb_media_id = thumb_media_id;
            this.author = author;
            this.content_source_url = content_source_url;
            this.content = content;
            this.digest = digest;
            this.show_cover_pic = show_cover_pic;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getThumb_media_id() {
            return thumb_media_id;
        }

        public void setThumb_media_id(String thumb_media_id) {
            this.thumb_media_id = thumb_media_id;
        }

        public String getShow_cover_pic() {
            return show_cover_pic;
        }

        public void setShow_cover_pic(String show_cover_pic) {
            this.show_cover_pic = show_cover_pic;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public String getContent_source_url() {
            return content_source_url;
        }

        public void setContent_source_url(String content_source_url) {
            this.content_source_url = content_source_url;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

    }

}
