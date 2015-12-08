package org.txazo.classfile.analysis.config;

import org.xml.sax.helpers.DefaultHandler;

public abstract class TagHandler extends DefaultHandler {

    public abstract Tag getRootTag();

}
