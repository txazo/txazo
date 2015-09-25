package org.txazo.framework.core.io;

public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

    ClassLoader getClassLoader();

}
