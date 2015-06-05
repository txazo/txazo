package org.txazo.weixin.config;

import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * DefaultDocumentLoader
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public class DefaultDocumentLoader implements DocumentLoader {

    @Override
    public Document loadDocument(InputSource inputSource, EntityResolver entityResolver, ErrorHandler errorHandler) throws Exception {
        DocumentBuilderFactory factory = this.createDocumentBuilderFactory();
        DocumentBuilder builder = this.createDocumentBuilder(factory, entityResolver, errorHandler);
        return builder.parse(inputSource);
    }

    protected DocumentBuilderFactory createDocumentBuilderFactory() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(true);
        try {
            factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
        } catch (IllegalArgumentException e) {
            ParserConfigurationException exception = new ParserConfigurationException("not support XSD");
            exception.initCause(e);
            throw exception;
        }
        return factory;
    }

    protected DocumentBuilder createDocumentBuilder(DocumentBuilderFactory factory, EntityResolver entityResolver, ErrorHandler errorHandler) throws ParserConfigurationException {
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        if (entityResolver != null) {
            docBuilder.setEntityResolver(entityResolver);
        }
        if (errorHandler != null) {
            docBuilder.setErrorHandler(errorHandler);
        }
        return docBuilder;
    }

}
