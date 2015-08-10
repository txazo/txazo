package org.txazo.blog.common.controller;

import org.apache.commons.lang3.StringUtils;
import org.txazo.blog.common.util.CommonUtils;
import org.txazo.blog.module.user.bean.User;

/**
 * BaseController
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.07.2015
 */
public abstract class BaseController {

    protected User getUser() {
        return CommonUtils.getUser();
    }

    protected int getUserId() {
        User user = getUser();
        return user != null ? user.getId() : 0;
    }

    protected String getUserName() {
        User user = getUser();
        return user != null ? user.getUserName() : StringUtils.EMPTY;
    }

}
