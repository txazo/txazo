package org.txazo.wx.menu.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.txazo.log.LoggerUtils;
import org.txazo.wx.access.service.AccessTokenService;
import org.txazo.wx.http.service.HttpService;
import org.txazo.wx.menu.service.MenuService;

import java.util.HashMap;
import java.util.Map;

/**
 * MenuServiceImpl
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.06.2015
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private AccessTokenService accessTokenService;

    @Autowired
    private HttpService httpService;

    @Override
    public void createMenu() {
        String accessToken = accessTokenService.getAccessToken();
        if (StringUtils.isBlank(accessToken)) {
            return;
        }

        String a = "{\n" +
                "  \"button\": [\n" +
                "    {\n" +
                "      \"type\": \"click\",\n" +
                "      \"name\": \"今日歌曲\",\n" +
                "      \"key\": \"V1001_TODAY_MUSIC\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"菜单\",\n" +
                "      \"sub_button\": [\n" +
                "        {\n" +
                "          \"type\": \"view\",\n" +
                "          \"name\": \"搜搜\",\n" +
                "          \"url\": \"http://www.soso.com/\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"type\": \"click\",\n" +
                "          \"name\": \"赞一下我们\",\n" +
                "          \"key\": \"V1001_GOOD\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("access_token", accessToken);
        params.put("agentid", 3);
        String result = httpService.post("https://qyapi.weixin.qq.com/cgi-bin/menu/create", params, a);
        LoggerUtils.log(result);
    }

}
