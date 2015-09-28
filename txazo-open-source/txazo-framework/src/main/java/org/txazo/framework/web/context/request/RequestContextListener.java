package org.txazo.framework.web.context.request;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class RequestContextListener implements ServletRequestListener {

    private static final String REQUEST_ATTRIBUTES_ATTRIBUTE = RequestContextListener.class.getName() + ".REQUEST_ATTRIBUTES";

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        if (!(event.getServletRequest() instanceof HttpServletRequest)) {
            throw new IllegalArgumentException("Request is not an HttpServletRequest");
        }

        HttpServletRequest request = (HttpServletRequest) event.getServletRequest();
        ServletRequestAttributes attributes = new ServletRequestAttributes(request);
        request.setAttribute(REQUEST_ATTRIBUTES_ATTRIBUTE, attributes);
        RequestContextHolder.setRequestAttributes(attributes);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        RequestAttributes threadAttributes = RequestContextHolder.getRequestAttributes();
        if (threadAttributes != null) {
            RequestContextHolder.resetRequestAttributes();
        }
    }

}
