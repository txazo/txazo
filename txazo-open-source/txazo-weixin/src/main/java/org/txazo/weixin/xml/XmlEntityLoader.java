package org.txazo.weixin.xml;

import java.util.List;

/**
 * DefaultXmlEntityHandler
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 06.06.2015
 */
public interface XmlEntityLoader<T extends XmlEntity> extends XmlEntityDefinition {

    List<T> load(Class<T> clazz);

}
