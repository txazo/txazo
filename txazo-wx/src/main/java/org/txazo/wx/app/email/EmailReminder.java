package org.txazo.wx.app.email;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Component;
import org.txazo.weixin.WeiXinUtils;
import org.txazo.weixin.develop.message.Message;
import org.txazo.weixin.develop.message.MessageBuilder;
import org.txazo.weixin.develop.message.NewsMessage;
import org.txazo.wx.app.common.constant.WeiXinApp;
import org.txazo.wx.app.email.bean.Email;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * EmailReminder
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 18.06.2015
 */
@Component
public class EmailReminder {

    public void sendEmailRemind(List<Email> emails) {
        if (CollectionUtils.isEmpty(emails)) {
            return;
        }

        Collections.sort(emails, new EmailComparator());

        for (Email email : emails) {
            WeiXinUtils.sendMessage(buildEmailMessage(email));
        }
    }

    private Message buildEmailMessage(Email email) {
        NewsMessage.Article article = new NewsMessage.Article();
        article.setTitle("163邮件提醒");
        StringBuilder sb = new StringBuilder();
        sb.append("<font style=\"color:red;\">发件人: " + email.getFrom() + "</font>\n");
        sb.append("收件人: " + email.getTo() + "\n");
        sb.append("时间: " + DateFormatUtils.format(email.getSendTime(), "yyyy-MM-dd HH:mm:ss") + "\n");
        sb.append("内容: " + email.getSubject());
        article.setDescription(sb.toString());
        article.setUrl("http://wx.txazo.com/email/read/" + email.getId() + ".wx");
        return MessageBuilder.buildNewsMessage(WeiXinApp.ACCOUNT, null, null, WeiXinApp.APP_EMAIL_ID, "0", article);
    }

    private class EmailComparator implements Comparator<Email> {

        @Override
        public int compare(Email e1, Email e2) {
            return e1.getSendTime().after(e2.getSendTime()) ? 1 : -1;
        }

    }

}
