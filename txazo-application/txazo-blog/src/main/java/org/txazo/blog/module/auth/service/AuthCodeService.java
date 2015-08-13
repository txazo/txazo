package org.txazo.blog.module.auth.service;

/**
 * AuthCodeService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 13.08.2015
 */
public interface AuthCodeService {

    public String getEmailValidateCode(String email);

    public boolean checkEmailValidateCode(String email, String code);

}
