package org.txazo.weixin.config;

import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;

/**
 * DocumentLoader
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public interface DocumentLoader {

    Document loadDocument(InputSource inputSource, EntityResolver entityResolver, ErrorHandler errorHandler) throws Exception;

}
