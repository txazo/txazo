package org.txazo.weixin.xml;

import org.txazo.log.LoggerUtils;
import org.txazo.weixin.bean.Crop;
import org.txazo.weixin.bean.Request;
import org.txazo.weixin.resource.DefaultResourceLoader;
import org.txazo.weixin.resource.Resource;
import org.txazo.weixin.resource.ResourceLoader;

import java.io.InputStream;
import java.util.List;

/**
 * DefaultXmlEntityLoader
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 06.06.2015
 */
public class DefaultXmlEntityLoader<T extends XmlEntity> implements XmlEntityLoader<T> {

    private static DefaultXmlEntityLoader instance;

    private ResourceLoader resourceLoader = new DefaultResourceLoader();
    private XmlEntityRegistry xmlEntityRegistry = new DefaultXmlEntityRegistry();
    private XmlEntityParser xmlEntityParser = new DefaultXmlEntityParser();

    private DefaultXmlEntityLoader() {
        initLoader();
    }

    private void initLoader() {
        registerXmlEntiry("classpath:crop.xml", Crop.class);
        registerXmlEntiry("classpath:request.xml", Request.class);
    }

    private void registerXmlEntiry(String path, Class<? extends XmlEntity> clazz) {
        xmlEntityRegistry.registerXmlEntity(path, clazz);
    }

    @Override
    public List<T> load(Class<T> clazz) {
        String path = xmlEntityRegistry.getRegisteredPath(clazz);
        Resource resource = resourceLoader.getResource(path);
        if (resource == null) {
            return null;
        }

        try {
            InputStream inputStream = resource.getInputStream();
            return xmlEntityParser.parse(inputStream, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static DefaultXmlEntityLoader getInstance() {
        if (instance == null) {
            synchronized (DefaultXmlEntityLoader.class) {
                if (instance == null) {
                    instance = new DefaultXmlEntityLoader();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        XmlEntityLoader loader = new DefaultXmlEntityLoader();
        List<Request> list = loader.load(Request.class);
        LoggerUtils.log("Success");
    }

}
