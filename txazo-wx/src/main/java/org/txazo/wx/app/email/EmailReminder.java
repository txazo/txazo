package org.txazo.wx.app.email;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;
import org.txazo.weixin.WeiXinUtils;
import org.txazo.weixin.develop.message.MessageBuilder;
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
            WeiXinUtils.sendMessage(MessageBuilder.buildTextMessage("txazo1218", "4", email.getSubject()));
        }
    }

    private class EmailComparator implements Comparator<Email> {

        @Override
        public int compare(Email e1, Email e2) {
            return e1.getSendTime().after(e2.getSendTime()) ? 1 : -1;
        }

    }

}
