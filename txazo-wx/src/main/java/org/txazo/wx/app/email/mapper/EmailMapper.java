package org.txazo.wx.app.email.mapper;

import org.txazo.wx.app.email.bean.Email;

/**
 * EmailMapper
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 18.06.2015
 */
public interface EmailMapper {

    public int addEmail(Email email);

    public Email getEmail(int id);

}
