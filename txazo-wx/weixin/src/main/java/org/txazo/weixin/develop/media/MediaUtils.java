package org.txazo.weixin.develop.media;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.txazo.log.LoggerUtils;
import org.txazo.weixin.WeiXinHolder;
import org.txazo.weixin.resource.Resource;

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
        if (StringUtils.isNoneBlank(mediaId)) {
            return mediaId;
        }

        Resource resource = resourceLoader.getResource(path);
        try {
            String result = executor.executeRequest("/cgi-bin/media/upload", createParams("type", "image"), "media", resource.getFile());
            Media media = JSON.parseObject(result, Media.class);
            if (media != null) {
                media.setPath(path);
                media.setCreated_at(System.currentTimeMillis());
                mediaHolder.storeMedia(media);
            }
            return media.getMedia_id();
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
//        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("/Users/txazo/TxazoCode/txazo/txazo-wx/weixin/src/main/resources/media.data"));
//        Media media = new Media();
//        os.writeObject(media);
//        IOUtils.closeQuietly(os);

        LoggerUtils.log(MediaUtils.getMediaId("classpath:images/agent_0.jpg"));
        LoggerUtils.log(MediaUtils.getMediaId("classpath:images/agent_0.jpg"));
        System.exit(0);
    }

}
