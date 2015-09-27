package org.txazo.framework.context;

import javax.servlet.ServletContext;

public interface WebApplicationContext extends ApplicationContext {

    ServletContext getServletContext();

}
