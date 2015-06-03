package org.txazo.wx.access.service.impl;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.txazo.wx.access.service.AccessTokenService;
import org.txazo.wx.access.vo.AccessToken;
import org.txazo.wx.http.service.HttpService;

import java.util.HashMap;
import java.util.Map;

/**
 * AccessTokenServiceImpl
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.06.2015
 */
@Service
public class AccessTokenServiceImpl implements AccessTokenService {

    @Autowired
    private HttpService httpService;

    @Override
    public String getAccessToken() {
        /** get from cache */

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("corpid", "wxb6d9c5e36e0501f8");
        params.put("corpsecret", "WF6CeWYF9H9GnMic9EgtqLC7QROr_K8ZEzGpBvPYJF_IVGtgQ_iMszPvkYQ1Gx88");
        String result = httpService.get("https://qyapi.weixin.qq.com/cgi-bin/gettoken", params);

        AccessToken accessToken = null;
        try {
            accessToken = JSON.parseObject(result, AccessToken.class);

            /** put into cache */
        } catch (Exception e) {
            e.printStackTrace();
        }

        return accessToken != null ? accessToken.getAccess_token() : StringUtils.EMPTY;
    }

}
