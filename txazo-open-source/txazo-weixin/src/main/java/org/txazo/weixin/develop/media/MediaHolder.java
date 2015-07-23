package org.txazo.weixin.develop.media;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.txazo.weixin.resource.DefaultResourceLoader;
import org.txazo.weixin.resource.ResourceLoader;
import org.txazo.weixin.util.AssertUtils;

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
class MediaHolder {

    private static final String MEDIA_DATA_FILE = "classpath:weixin-media.data";

    private ResourceLoader resourceLoader = new DefaultResourceLoader();
    /** media_id缓存 */
    private Map<String, Media> medias = new ConcurrentHashMap<String, Media>();

    public MediaHolder() {
        try {
            loadMedia();
        } catch (IOException e) {
            throw new RuntimeException(MEDIA_DATA_FILE + " load failed", e);
        }
    }

    public void loadMedia() throws IOException {
        ObjectInputStream reader = null;
        try {
            reader = new ObjectInputStream(new FileInputStream(resourceLoader.getResource(MEDIA_DATA_FILE).getFile()));
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

    public void storeMedia(Media media) {
        AssertUtils.assertNotNull(media, "media must not be null");
        String md5 = getMD5(media.getPath());
        if (StringUtils.isNotBlank(md5)) {
            media.setHash(md5);
            ObjectOutputStream writer = null;
            try {
                writer = new ObjectOutputStream(new FileOutputStream(resourceLoader.getResource(MEDIA_DATA_FILE).getFile()));
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
        if (StringUtils.isBlank(md5)) {
            return StringUtils.EMPTY;
        }

        Media media = medias.get(md5);
        return media != null && media.isVaild() ? media.getMedia_id() : StringUtils.EMPTY;
    }

    private String getMD5(String path) {
        InputStream is = null;
        try {
            is = resourceLoader.getResource(path).getInputStream();
            return MediaMD5.getMD5(is);
        } catch (Exception e) {
            return StringUtils.EMPTY;
        } finally {
            IOUtils.closeQuietly(is);
        }
    }

}
