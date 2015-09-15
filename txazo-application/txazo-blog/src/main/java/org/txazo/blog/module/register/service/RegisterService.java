package org.txazo.blog.module.register.service;

import org.txazo.blog.module.register.bean.RegisterResult;

/**
 * RegisterService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 12.08.2015
 */
public interface RegisterService {

    public RegisterResult register(String email, String userName, String passWord);

}
