package org.txazo.weixin.xml;

import java.util.HashMap;
import java.util.Map;

/**
 * DefaultXmlEntityRegistry
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 06.06.2015
 */
public class DefaultXmlEntityRegistry<T extends XmlEntity> implements XmlEntityRegistry<T> {

    private Map<Class<T>, String> xmlEntitys = new HashMap<Class<T>, String>();

    @Override
    public void registerXmlEntity(String path, Class<T> clazz) {
        xmlEntitys.put(clazz, path);
    }

    @Override
    public String getRegisteredPath(Class<T> clazz) {
        return xmlEntitys.get(clazz);
    }

}
