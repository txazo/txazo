package org.txazo.wx.app.email.service;

import org.txazo.wx.app.email.bean.Account;
import org.txazo.wx.app.email.bean.Email;

import java.util.List;

/**
 * EmailService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 15.06.2015
 */
public interface EmailReceiveService {

    List<Email> receiveEmail(Account account) throws Exception;

}
