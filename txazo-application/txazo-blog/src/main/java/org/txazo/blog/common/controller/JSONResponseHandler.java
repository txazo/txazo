package org.txazo.blog.common.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang.StringUtils;
import org.txazo.util.collection.map.MapUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * JSONResponseHandler
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 14.08.2015
 */
public abstract class JSONResponseHandler extends ResponseHandler {

    protected static final ResponseStatus ERROR = ResponseStatus.ERROR;
    protected static final ResponseStatus SUCCESS = ResponseStatus.SUCCESS;

    protected enum ResponseStatus {

        ERROR(false), SUCCESS(true);

        private boolean status;

        ResponseStatus(boolean status) {
            this.status = status;
        }

        public boolean isStatus() {
            return status;
        }

    }

    protected void responseJSON(String message) {
        responseJson(message);
    }

    protected void responseJSON(Object data) {
        responseJson(JSON.toJSONString(data));
    }

    protected void responseJSON(Collection collection) {
        responseJson(JSONArray.toJSONString(collection));
    }

    protected void responseJSON(Map map) {
        responseJson(JSONArray.toJSONString(map));
    }

    protected void responseJSON(Object... keyValuePairs) {
        responseJSON(MapUtils.buildMap(keyValuePairs));
    }

    protected void responseJSON(ResponseStatus status) {
        responseJSON(status, null, null);
    }

    protected void responseJSON(ResponseStatus status, String message) {
        responseJSON(status, message, null);
    }

    protected void responseJSON(ResponseStatus status, Object data) {
        responseJSON(status, null, data);
    }

    protected void responseJSON(ResponseStatus status, Object... keyValuePairs) {
        responseJSON(status, null, MapUtils.buildMap(keyValuePairs));
    }

    protected void responseJSON(ResponseStatus status, String message, Object data) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        if (status != null) {
            jsonMap.put("status", status.isStatus());
        }
        if (StringUtils.isNotBlank(message)) {
            jsonMap.put("message", message);
        }
        if (data != null) {
            jsonMap.put("data", data);
        }
        responseJson(JSONArray.toJSONString(jsonMap));
    }

}
