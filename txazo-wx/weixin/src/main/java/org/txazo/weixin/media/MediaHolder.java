package org.txazo.weixin.media;

import org.apache.commons.io.IOUtils;
import org.txazo.weixin.resource.DefaultResourceLoader;
import org.txazo.weixin.resource.Resource;
import org.txazo.weixin.resource.ResourceLoader;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * MediaHolder
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 09.06.2015
 */
public class MediaHolder {

    private static final String MEDIA_DATA_FILE = "classpath:media.data";

    private ResourceLoader resourceLoader = new DefaultResourceLoader();
    private Map<String, Media> medias = new ConcurrentHashMap<String, Media>();

    public MediaHolder() {
        try {
            loadMedia();
        } catch (IOException e) {
            throw new RuntimeException(MEDIA_DATA_FILE + " load failed");
        }
    }

    public void loadMedia() throws IOException {
        Resource resource = resourceLoader.getResource(MEDIA_DATA_FILE);
        if (resource != null) {
            ObjectInputStream reader = null;
            try {
                reader = new ObjectInputStream(new FileInputStream(resource.getFile()));
                while (true) {
                    Media media = (Media) reader.readObject();
                    if (media == null) {
                        break;
                    }
                    if (media.getHash() != null) {
                        medias.put(media.getHash(), media);
                    }
                }
            } catch (Exception e) {
            } finally {
                IOUtils.closeQuietly(reader);
            }
        }
    }

    public void storeMedia(Media media) {
        String md5 = getMD5(media.getPath());
        if (md5 != null) {
            media.setHash(md5);
            Resource resource = resourceLoader.getResource(MEDIA_DATA_FILE);
            ObjectOutputStream writer = null;
            try {
                writer = new ObjectOutputStream(new FileOutputStream(resource.getFile()));
                writer.writeObject(media);
                medias.put(media.getHash(), media);
            } catch (Exception e) {
            } finally {
                IOUtils.closeQuietly(writer);
            }
        }
    }

    public String getMediaId(String path) {
        String md5 = getMD5(path);
        if (md5 == null) {
            return null;
        }

        Media media = medias.get(md5);
        return media != null && media.isVaild() ? media.getMedia_id() : null;
    }

    private String getMD5(String path) {
        try {
            Resource resource = resourceLoader.getResource(path);
            return MediaMD5.getMD5(resource.getInputStream());
        } catch (Exception e) {
            return null;
        }
    }

}
