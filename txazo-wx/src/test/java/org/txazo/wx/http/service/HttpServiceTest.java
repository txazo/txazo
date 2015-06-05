package org.txazo.wx.http.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.txazo.log.LoggerUtils;
import org.txazo.wx.SpringAbstractTest;
import org.txazo.wx.access.service.AccessTokenService;
import org.txazo.wx.http.client.PoolHttpClient;
import org.txazo.wx.weixin.media.MediaType;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * HttpServiceTest
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.06.2015
 */
public class HttpServiceTest extends SpringAbstractTest {

    @Autowired
    private HttpService httpService;

    @Autowired
    private AccessTokenService accessTokenService;

    @Test
    public void testGet() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("corpid", 1);
        String result = httpService.get("https://qyapi.weixin.qq.com/cgi-bin/gettoken", map);
        LoggerUtils.log(result);
    }

    @Test
    public void testPost() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 1);
        String result = httpService.post("http://wx.txazo.com/index.wx", map);
        LoggerUtils.log(result);
    }

    @Test
    public void testPostFile() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("access_token", accessTokenService.getAccessToken());
        map.put("type", MediaType.IMAGE.getType());
        String result = PoolHttpClient.getInstance().post("https://qyapi.weixin.qq.com/cgi-bin/media/upload", map, new File(this.getClass().getResource("/image/icon-agent_1.jpg").getPath()));
        LoggerUtils.log(result);
    }

}
