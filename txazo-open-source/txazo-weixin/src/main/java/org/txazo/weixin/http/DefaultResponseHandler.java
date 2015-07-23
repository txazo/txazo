package org.txazo.weixin.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * DefaultResponseHandler
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.06.2015
 */
public class DefaultResponseHandler implements ResponseHandler<String> {

    @Override
    public String handleResponse(HttpResponse response) throws IOException {
        int status = response.getStatusLine().getStatusCode();
        if (status >= 200 && status < 300) {
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                throw new ClientProtocolException("Response contains no content");
            }
            return EntityUtils.toString(entity);
        } else {
            throw new ClientProtocolException("Unexpected response status: " + status);
        }
    }

}
