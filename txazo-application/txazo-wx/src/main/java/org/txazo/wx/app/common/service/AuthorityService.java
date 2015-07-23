package org.txazo.wx.app.common.service;

import org.txazo.wx.app.common.enums.PrivilegeType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AuthorityService
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 30.06.2015
 */
public interface AuthorityService {

    public boolean checkAuthority(HttpServletRequest request, HttpServletResponse response, PrivilegeType type);

}
