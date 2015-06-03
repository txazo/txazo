package org.txazo.wx.http.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.txazo.log.LoggerUtils;
import org.txazo.wx.SpringAbstractTest;

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

}
