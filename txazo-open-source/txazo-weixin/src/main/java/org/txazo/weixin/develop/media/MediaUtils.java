package org.txazo.weixin.develop.media;

import org.apache.commons.lang3.StringUtils;
import org.txazo.weixin.WeiXinHolder;

/**
 * MediaUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 09.06.2015
 */
public abstract class MediaUtils extends WeiXinHolder {

    private static MediaHolder mediaHolder = new MediaHolder();

    public static String getMediaId(String path) {
        String mediaId = mediaHolder.getMediaId(path);
        if (StringUtils.isNotBlank(mediaId)) {
            return mediaId;
        }

        try {
            String result = executor.executeRequest(URI_MEDIA_UPLOAD, createParams("type", "image"), "media", resourceLoader.getResource(path).getFile());
            Media media = parseResult(result, Media.class);
            if (media != null) {
                media.setPath(path);
                media.setCreated_at(System.currentTimeMillis());
                mediaHolder.storeMedia(media);
                return media.getMedia_id();
            }
        } catch (Exception e) {
        }
        return StringUtils.EMPTY;
    }

}
