package org.txazo.wx.app.email.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.txazo.wx.app.email.bean.Email;
import org.txazo.wx.app.email.bean.EmailContent;
import org.txazo.wx.app.email.mapper.EmailContentMapper;
import org.txazo.wx.app.email.mapper.EmailMapper;
import org.txazo.wx.app.email.service.EmailService;

/**
 * EmailServiceImpl
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 18.06.2015
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailMapper emailMapper;

    @Autowired
    private EmailContentMapper emailContentMapper;

    @Override
    public boolean addEmail(Email email) {
        if (email == null || email.getEmailContent() == null) {
            return false;
        }

        try {
            EmailContent emailContent = email.getEmailContent();
            emailContentMapper.addEmailContent(emailContent);
            if (emailContent.getId() <= 0) {
                return false;
            }

            email.setContentId(emailContent.getId());
            emailMapper.addEmail(email);
            return email.getId() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Email getEmail(int id) {
        Email email = emailMapper.getEmail(id);
        if (email != null) {
            email.setEmailContent(emailContentMapper.getEmailContent(email.getContentId()));
        }
        return email;
    }

}
