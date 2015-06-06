package org.txazo.weixin.xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.util.List;

/**
 * DefaultXmlEntityParser
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 06.06.2015
 */
public class DefaultXmlEntityParser<T extends XmlEntity> implements XmlEntityParser<T> {

    private SAXParserFactory factory;
    private SAXParser parser;

    public DefaultXmlEntityParser() {
        factory = SAXParserFactory.newInstance();
        try {
            parser = factory.newSAXParser();
        } catch (Exception e) {
            throw new RuntimeException("DefaultXmlEntityParser init failed");
        }
    }

    @Override
    public List<T> parse(InputStream inputStream, Class<T> clazz) throws Exception {
        XmlEntityHandler handler = new DefaultXmlEntityHandler(clazz);
        parser.parse(inputStream, handler);
        return handler.getResultEntity();
    }

}
