package org.txazo.weixin.xml;

import org.apache.commons.io.IOUtils;
import org.txazo.weixin.bean.Crop;
import org.txazo.weixin.develop.verify.Verify;
import org.txazo.weixin.http.Request;
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

    private static volatile DefaultXmlEntityLoader instance;

    private ResourceLoader resourceLoader = new DefaultResourceLoader();
    private XmlEntityRegistry xmlEntityRegistry = new DefaultXmlEntityRegistry();
    private XmlEntityParser xmlEntityParser = new DefaultXmlEntityParser();

    private DefaultXmlEntityLoader() {
        initLoader();
    }

    private void initLoader() {
        registerXmlEntiry("classpath:weixin-crop.xml", Crop.class);
        registerXmlEntiry("classpath:weixin-request.xml", Request.class);
        registerXmlEntiry("classpath:weixin-verify.xml", Verify.class);
    }

    public void registerXmlEntiry(String path, Class<? extends XmlEntity> clazz) {
        xmlEntityRegistry.registerXmlEntity(path, clazz);
    }

    @Override
    public List<T> load(Class<T> clazz) {
        String path = xmlEntityRegistry.getRegisteredPath(clazz);
        Resource resource = resourceLoader.getResource(path);
        if (resource == null) {
            return null;
        }

        InputStream inputStream = null;
        try {
            inputStream = resource.getInputStream();
            return xmlEntityParser.parse(inputStream, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            IOUtils.closeQuietly(inputStream);
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

}
