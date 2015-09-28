package org.txazo.framework.web.context;

import org.txazo.framework.bean.BeanUtils;
import org.txazo.framework.context.ApplicationContextException;
import org.txazo.framework.core.io.ClassPathResource;
import org.txazo.framework.core.io.support.PropertiesLoaderUtils;
import org.txazo.framework.util.ClassUtils;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.Properties;

public class ContextLoader {

    public static final String CONTEXT_CLASS_PARAM = "contextClass";

    private static final String DEFAULT_STRATEGIES_PATH = "ContextLoader.properties";

    private static final Properties defaultStrategies;

    static {
        try {
            ClassPathResource resource = new ClassPathResource(DEFAULT_STRATEGIES_PATH);
            defaultStrategies = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException ex) {
            throw new IllegalStateException("Could not load ContextLoader.properties", ex);
        }
    }

    private WebApplicationContext context;

    public void initContext(ServletContext servletContext) {
        servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, this.context);
    }

    protected WebApplicationContext createWebApplicationContext(ServletContext servletContext) {
        Class<?> contextClass = determineContextClass(servletContext);
        if (!WebApplicationContext.class.isAssignableFrom(contextClass)) {
            throw new ApplicationContextException("Custom context class " + contextClass.getName() + " is not type of " + WebApplicationContext.class.getName());
        }
        return (WebApplicationContext) BeanUtils.instantiateClass(contextClass);
    }

    protected Class<?> determineContextClass(ServletContext servletContext) {
        String contextClassName = defaultStrategies.getProperty(WebApplicationContext.class.getName());
        try {
            return ClassUtils.forName(contextClassName, ContextLoader.class.getClassLoader());
        } catch (ClassNotFoundException ex) {
            throw new ApplicationContextException("Failed to load default context class " + contextClassName, ex);
        }
    }

    public void closeContext(ServletContext servletContext) {

    }

}
