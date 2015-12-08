package org.txazo.classfile.analysis.config;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.*;

public class DefaultTagHandler extends TagHandler {

    private Tag root;

    private Tag currentTag;

    private Stack<Tag> parentTagStack = new Stack<Tag>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (Tag.ROOT_TAG_NAME.equals(qName)) {
            root = new Tag(qName);
            parentTagStack.push(root);
        } else {
            currentTag = new Tag(qName, readAttributes(attributes));

            parentTagStack.peek().addChild(currentTag);

            if (currentTag.isParent()) {
                parentTagStack.push(currentTag);
            }
        }
    }

    private Map<String, String> readAttributes(Attributes attributes) {
        int length = attributes.getLength();
        Map<String, String> attributeMap = new HashMap<String, String>();
        for (int i = 0; i < length; i++) {
            attributeMap.put(attributes.getQName(i), attributes.getValue(i));
        }
        return attributeMap;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        Tag parentTag = parentTagStack.peek();
        if (parentTag.getName().equals(qName) && parentTag.isParent()) {
            parentTagStack.pop();
        }
    }

    @Override
    public Tag getRootTag() {
        return root;
    }

}
