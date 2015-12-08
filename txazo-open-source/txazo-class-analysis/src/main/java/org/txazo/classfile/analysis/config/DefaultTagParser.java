package org.txazo.classfile.analysis.config;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;

public class DefaultTagParser implements TagParser {

    private SAXParser parser;
    private SAXParserFactory factory;

    public DefaultTagParser() {
        factory = SAXParserFactory.newInstance();
        try {
            factory.setFeature("http://xml.org/sax/features/namespaces", true);
            factory.setFeature("http://xml.org/sax/features/validation", true);
            parser = factory.newSAXParser();
        } catch (Exception e) {
            throw new RuntimeException("DefaultTagParser init failed");
        }
    }

    @Override
    public Tag parse(InputStream inputStream) throws Exception {
        TagHandler handler = new DefaultTagHandler();
        parser.parse(inputStream, handler);
        return handler.getRootTag();
    }

    public static void main(String[] args) throws Exception {
        TagParser parser = new DefaultTagParser();
        Tag root = parser.parse(DefaultTagParser.class.getResourceAsStream("/class.xml"));
    }

}
