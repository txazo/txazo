package org.txazo.wx.app.email;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Component;
import org.txazo.weixin.WeiXinUtils;
import org.txazo.weixin.develop.message.Message;
import org.txazo.weixin.develop.message.MessageBuilder;
import org.txazo.weixin.develop.message.NewsMessage;
import org.txazo.wx.app.email.bean.Email;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/**
 * EmailReminder
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 18.06.2015
 */
@Component
public class EmailReminder {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

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
        article.setTitle(email.getFrom());
        StringBuilder sb = new StringBuilder();
        sb.append(email.getSubject());
        sb.append(LINE_SEPARATOR);
        sb.append(LINE_SEPARATOR);
        sb.append("收件人: " + email.getTo());
        sb.append(LINE_SEPARATOR);
        sb.append("时    间: " + DateFormatUtils.format(email.getSendTime(), "yyyy年MM月dd日 HH:mm (E)", Locale.CHINESE));
        article.setDescription(sb.toString());
        article.setUrl("http://wx.txazo.com/email/read/" + email.getId() + ".wx");
//        return MessageBuilder.buildNewsMessage(WeiXinApp.ACCOUNT, null, null, WeiXinApp.APP_EMAIL_ID, "0", article);
        return null;
    }

    private class EmailComparator implements Comparator<Email> {

        @Override
        public int compare(Email e1, Email e2) {
            return e1.getSendTime().after(e2.getSendTime()) ? 1 : -1;
        }

    }

}
