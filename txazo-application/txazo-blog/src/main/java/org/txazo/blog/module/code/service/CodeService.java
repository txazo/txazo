package org.txazo.blog.module.code.service;

import org.txazo.blog.module.code.enums.CodeType;

/**
 * CodeService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 13.08.2015
 */
public interface CodeService {

    public String getCode(int userId, CodeType type);

    public boolean validateCode(int userId, CodeType type, String code);

}
