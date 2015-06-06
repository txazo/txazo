package org.txazo.weixin.xml;

/**
 * XmlEntityRegistry
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 06.06.2015
 */
public interface XmlEntityRegistry<T extends XmlEntity> extends XmlEntityDefinition {

    void registerXmlEntity(String path, Class<T> clazz);

    String getRegisteredPath(Class<T> clazz);

}
