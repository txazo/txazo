package org.txazo.wx.app.email;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.txazo.wx.app.email.bean.Account;
import org.txazo.wx.app.email.bean.Email;
import org.txazo.wx.app.email.service.EmailService;

import java.util.List;

/**
 * EmailReceiver
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 15.06.2015
 */
@Service
public class EmailReceiver {

    private AccountLoader accountLoader = AccountLoader.getInstance();

    @Autowired
    private EmailService emailService;

    public void receiveEmail() {
        List<Account> accounts = accountLoader.getAccounts();
        if (CollectionUtils.isNotEmpty(accounts)) {
            for (Account account : accounts) {
                try {
                    List<Email> emails = emailService.receiveEmail(account);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
