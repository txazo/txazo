package org.txazo.framework.web.context.request;

public interface RequestAttributes {

    Object getAttribute(String name, int scope);

    void setAttribute(String name, Object value, int scope);

    void removeAttribute(String name, int scope);

    String[] getAttributeNames(int scope);

    String getSessionId();

}
