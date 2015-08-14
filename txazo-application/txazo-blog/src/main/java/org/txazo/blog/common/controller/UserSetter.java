package org.txazo.blog.common.controller;

import org.apache.commons.lang3.StringUtils;
import org.txazo.blog.module.user.bean.User;

import javax.servlet.http.HttpServletRequest;

/**
 * UserSetter
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 14.08.2015
 */
public abstract class UserSetter extends JSONResponseHandler {

    protected User getUser() {
        HttpServletRequest request = getRequest();
        return request != null ? (User) request.getAttribute("user") : null;
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
