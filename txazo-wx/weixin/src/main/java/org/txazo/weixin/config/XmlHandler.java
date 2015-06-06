package org.txazo.weixin.config;

import org.txazo.log.LoggerUtils;
import org.txazo.weixin.bean.Request;
import org.txazo.weixin.resource.DefaultResourceLoader;
import org.txazo.weixin.resource.Resource;
import org.txazo.weixin.resource.ResourceLoader;
import org.txazo.weixin.xml.DefaultXmlEntityHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * XmlHandler
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 06.06.2015
 */
public class XmlHandler extends DefaultHandler {

    public XmlHandler() {
        super();
    }

    @Override
    public void startDocument() throws SAXException {
        LoggerUtils.log("startDocument");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        LoggerUtils.log("startElement");
        LoggerUtils.log("uri: " + uri + ", localName: " + localName + ", qName: " + qName);
        LoggerUtils.log(attributes.getValue("contentType"));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        LoggerUtils.log("uri: " + uri + ", localName: " + localName + ", qName: " + qName);
        LoggerUtils.log("endElement");
    }

    @Override
    public void endDocument() throws SAXException {
        LoggerUtils.log("endDocument");
    }

    public static void main(String[] args) throws Exception {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:request.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(resource.getInputStream(), new DefaultXmlEntityHandler(Request.class));
    }

}
