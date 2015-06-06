package org.txazo.weixin.xml;

import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

/**
 * XmlEntityHandler
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 06.06.2015
 */
public abstract class XmlEntityHandler<T extends XmlEntity> extends DefaultHandler implements XmlEntityDefinition {

    public abstract List<T> getResultEntity();

}
