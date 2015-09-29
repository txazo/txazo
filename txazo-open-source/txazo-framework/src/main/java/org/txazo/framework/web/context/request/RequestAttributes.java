package org.txazo.framework.web.context.request;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface RequestAttributes {

    Object getAttribute(String name, RequestScope scope);

    void setAttribute(String name, Object value, RequestScope scope);

    void removeAttribute(String name, RequestScope scope);

    String[] getAttributeNames(RequestScope scope);

    HttpServletRequest getRequest();

    HttpSession getSession();

    ServletContext getServletContext();

    enum RequestScope {

        REQUEST,

        SESSION

    }

}
