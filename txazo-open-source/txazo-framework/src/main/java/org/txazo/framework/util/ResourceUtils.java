package org.txazo.framework.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public abstract class ResourceUtils {

    public static URI toURI(URL url) throws URISyntaxException {
        return toURI(url.toString());
    }

    public static URI toURI(String location) throws URISyntaxException {
        return new URI(StringUtils.replace(location, " ", "%20"));
    }

}
