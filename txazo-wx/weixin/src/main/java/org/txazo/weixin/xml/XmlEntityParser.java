package org.txazo.weixin.xml;

import java.io.InputStream;
import java.util.List;

/**
 * XmlEntityParser
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 06.06.2015
 */
public interface XmlEntityParser<T extends XmlEntity> extends XmlEntityDefinition {

    List<T> parse(InputStream inputStream, Class<T> clazz) throws Exception;

}
