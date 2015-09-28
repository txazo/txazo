package org.txazo.framework.web.context;

import javax.servlet.ServletContext;

public interface WebApplicationContext {

    String ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE = WebApplicationContext.class.getName() + ".ROOT";

    ServletContext getServletContext();

}
