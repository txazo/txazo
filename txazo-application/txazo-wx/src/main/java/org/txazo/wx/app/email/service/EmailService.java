package org.txazo.wx.app.email.service;

import org.txazo.wx.app.email.bean.Email;

/**
 * EmailService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 18.06.2015
 */
public interface EmailService {

    public boolean addEmail(Email email);

    public Email getEmail(int id);

}
