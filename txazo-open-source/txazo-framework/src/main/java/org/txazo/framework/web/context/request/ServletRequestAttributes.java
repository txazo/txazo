package org.txazo.framework.web.context.request;

import org.txazo.framework.util.ArrayUtils;
import org.txazo.framework.util.Assert;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ServletRequestAttributes implements RequestAttributes {

    private final HttpServletRequest request;

    public ServletRequestAttributes(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public Object getAttribute(String name, RequestScope scope) {
        Assert.notNull(scope, "RequestScope must not be null");
        switch (scope) {
            case REQUEST:
                return getRequest().getAttribute(name);
            case SESSION:
                return getSession().getAttribute(name);
        }
        return null;
    }

    @Override
    public void setAttribute(String name, Object value, RequestScope scope) {
        Assert.notNull(scope, "RequestScope must not be null");
        switch (scope) {
            case REQUEST:
                getRequest().setAttribute(name, value);
            case SESSION:
                getSession().setAttribute(name, value);
        }
    }

    @Override
    public void removeAttribute(String name, RequestScope scope) {
        Assert.notNull(scope, "RequestScope must not be null");
        switch (scope) {
            case REQUEST:
                getRequest().removeAttribute(name);
            case SESSION:
                getSession().removeAttribute(name);
        }
    }

    @Override
    public String[] getAttributeNames(RequestScope scope) {
        Assert.notNull(scope, "RequestScope must not be null");
        switch (scope) {
            case REQUEST:
                return ArrayUtils.toArray(getRequest().getAttributeNames());
            case SESSION:
                return ArrayUtils.toArray(getSession().getAttributeNames());
        }
        return ArrayUtils.EMPTY_STRING;
    }

    @Override
    public HttpServletRequest getRequest() {
        return request;
    }

    @Override
    public HttpSession getSession() {
        return request.getSession();
    }

    @Override
    public ServletContext getServletContext() {
        return request.getSession().getServletContext();
    }

}
