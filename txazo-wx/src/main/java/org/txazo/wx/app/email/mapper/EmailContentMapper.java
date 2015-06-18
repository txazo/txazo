package org.txazo.wx.app.email.mapper;

import org.txazo.wx.app.email.bean.EmailContent;

/**
 * EmailContentMapper
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 18.06.2015
 */
public interface EmailContentMapper {

    public int addEmailContent(EmailContent content);

    public EmailContent getEmailContent(int id);

}
