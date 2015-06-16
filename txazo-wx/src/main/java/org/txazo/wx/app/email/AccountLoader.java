package org.txazo.wx.app.email;

import org.txazo.weixin.xml.DefaultXmlEntityLoader;
import org.txazo.wx.app.email.bean.Account;

import java.util.List;

/**
 * AccountLoader
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 15.06.2015
 */
public class AccountLoader {

    private static AccountLoader instance;

    private List<Account> accounts;

    private AccountLoader() {
        DefaultXmlEntityLoader loader = DefaultXmlEntityLoader.getInstance();
        loader.registerXmlEntiry("classpath:config/email-account.xml", Account.class);
        accounts = loader.load(Account.class);
    }

    public static AccountLoader getInstance() {
        if (instance == null) {
            synchronized (AccountLoader.class) {
                if (instance == null) {
                    instance = new AccountLoader();
                }
            }
        }
        return instance;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

}
