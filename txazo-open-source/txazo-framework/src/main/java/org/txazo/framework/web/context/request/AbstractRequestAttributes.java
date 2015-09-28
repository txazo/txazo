package org.txazo.framework.web.context.request;

public class AbstractRequestAttributes implements RequestAttributes {

    @Override
    public Object getAttribute(String name, int scope) {
        return null;
    }

    @Override
    public void setAttribute(String name, Object value, int scope) {
    }

    @Override
    public void removeAttribute(String name, int scope) {
    }

    @Override
    public String[] getAttributeNames(int scope) {
        return new String[0];
    }

    @Override
    public String getSessionId() {
        return null;
    }

}
