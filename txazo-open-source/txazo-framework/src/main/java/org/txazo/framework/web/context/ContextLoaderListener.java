package org.txazo.framework.web.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ContextLoaderListener
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 2015-09-16
 */
public class ContextLoaderListener extends ContextLoader implements ServletContextListener {

    public ContextLoaderListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        initContext(event.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        closeContext(event.getServletContext());
        ContextCleanupListener.cleanupAttributes(event.getServletContext());
    }

}
