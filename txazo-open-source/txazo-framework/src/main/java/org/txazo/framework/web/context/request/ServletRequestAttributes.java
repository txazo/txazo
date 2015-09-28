package org.txazo.framework.web.context.request;

import javax.servlet.http.HttpServletRequest;

public class ServletRequestAttributes extends AbstractRequestAttributes {

    private final HttpServletRequest request;

    public ServletRequestAttributes(HttpServletRequest request) {
        this.request = request;
    }

}
