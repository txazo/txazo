package org.txazo.weixin.develop.media;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * MediaMD5
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 09.06.2015
 */
public class MediaMD5 {

    public static String getMD5(InputStream inputStream) throws IOException {
        return DigestUtils.md5Hex(inputStream);
    }

}
