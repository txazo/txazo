package org.txazo.blog.common.controller;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang.StringUtils;

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

        ERROR(0), SUCCESS(1);

        private int id;

        ResponseStatus(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

    }

    protected void responseJSON(ResponseStatus status) {
        responseJSON(status, null, null);
    }

    protected void responseJSON(ResponseStatus status, String message, Object data) {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        if (status != null) {
            jsonMap.put("status", status.getId());
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
