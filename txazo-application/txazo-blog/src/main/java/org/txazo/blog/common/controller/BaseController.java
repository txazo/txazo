package org.txazo.blog.common.controller;

/**
 * BaseController
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 07.07.2015
 */
public abstract class BaseController extends UserSetter implements URIPathHolder {

    /**
     * 1) Request, Response注入
     * 2) JSON返回, 固定格式
     * 3) User获取
     * 4) Redirect
     */

    protected String redirectTo(String uri) {
        return "redirect:/" + uri;
    }

}
