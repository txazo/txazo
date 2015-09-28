package org.txazo.framework.web.context.request;

public abstract class RequestContextHolder {

    private static final ThreadLocal<RequestAttributes> requestAttributesHolder = new ThreadLocal<RequestAttributes>();

    public static void setRequestAttributes(RequestAttributes attributes) {
        if (attributes == null) {
            resetRequestAttributes();
        } else {
            requestAttributesHolder.set(attributes);
        }
    }

    public static RequestAttributes getRequestAttributes() {
        return requestAttributesHolder.get();
    }

    public static void resetRequestAttributes() {
        requestAttributesHolder.remove();
    }

}
