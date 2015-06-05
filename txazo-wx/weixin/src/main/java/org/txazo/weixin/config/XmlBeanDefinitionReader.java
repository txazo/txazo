package org.txazo.weixin.config;

import org.txazo.weixin.resource.Resource;
import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;

/**
 * XmlBeanDefinitionReader
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public class XmlBeanDefinitionReader implements BeanDefinitionReader {

    private DocumentLoader documentLoader = new DefaultDocumentLoader();
    private ErrorHandler errorHandler;

    public XmlBeanDefinitionReader() {
    }

    @Override
    public int loadBeanDefinitions(Resource resource) throws BeanDefinitionException {
        return 0;
    }

    @Override
    public int loadBeanDefinitions(Resource... resources) throws BeanDefinitionException {
        return 0;
    }

    @Override
    public int loadBeanDefinitions(String path) throws BeanDefinitionException {
        return 0;
    }

    @Override
    public int loadBeanDefinitions(String... paths) throws BeanDefinitionException {
        return 0;
    }

    protected int doLoadBeanDefinitions(InputSource inputSource, Resource resource) throws BeanDefinitionException {
        try {
            Document document = this.doLoadDocument(inputSource, resource);
        } catch (Exception e) {
            throw new BeanDefinitionException(e);
        }
        return 0;
    }

    protected Document doLoadDocument(InputSource inputSource, Resource resource) throws Exception {
        return this.documentLoader.loadDocument(inputSource, this.getEntityResolver(), this.errorHandler);
    }

    protected EntityResolver getEntityResolver() {
        return null;
    }

    public int registerBeanDefinitions(Document doc, Resource resource) throws BeanDefinitionException {
        return 0;
    }

}
