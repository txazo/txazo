package org.txazo.wx.app.authority.service;

import org.txazo.wx.app.authority.AuthorityType;

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

    public boolean checkAuthority(HttpServletRequest request, HttpServletResponse response, AuthorityType type);

}
