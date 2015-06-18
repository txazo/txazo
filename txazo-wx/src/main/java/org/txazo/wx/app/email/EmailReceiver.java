package org.txazo.wx.app.email;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.txazo.wx.app.email.bean.Account;
import org.txazo.wx.app.email.bean.Email;
import org.txazo.wx.app.email.service.EmailReceiveService;

import java.util.ArrayList;
import java.util.List;

/**
 * EmailReceiver
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 15.06.2015
 */
@Component
public class EmailReceiver {

    private AccountLoader accountLoader = AccountLoader.getInstance();

    @Autowired
    private EmailReceiveService emailReceiveService;

    public List<Email> receiveEmail() {
        List<Email> receiveEmails = null;
        List<Email> emails = new ArrayList<Email>();
        List<Account> accounts = accountLoader.getAccounts();
        if (CollectionUtils.isNotEmpty(accounts)) {
            for (Account account : accounts) {
                try {
                    receiveEmails = emailReceiveService.receiveEmail(account);
                    if (CollectionUtils.isNotEmpty(receiveEmails)) {
                        emails.addAll(receiveEmails);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return emails;
    }

}
