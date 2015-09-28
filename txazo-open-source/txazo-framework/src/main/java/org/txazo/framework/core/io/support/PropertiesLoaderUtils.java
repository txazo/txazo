package org.txazo.framework.core.io.support;

import org.txazo.framework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class PropertiesLoaderUtils {

    public static Properties loadProperties(Resource resource) throws IOException {
        Properties props = new Properties();
        fillProperties(props, resource);
        return props;
    }

    public static void fillProperties(Properties props, Resource resource) throws IOException {
        InputStream is = null;
        try {
            resource.getInputStream();
            props.load(is);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

}
