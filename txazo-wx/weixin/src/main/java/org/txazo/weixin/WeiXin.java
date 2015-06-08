package org.txazo.weixin;

import org.txazo.weixin.bean.Crop;
import org.txazo.weixin.http.Request;
import org.txazo.weixin.xml.DefaultXmlEntityLoader;
import org.txazo.weixin.xml.XmlEntityLoader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * WeiXin
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public class WeiXin {

    private static WeiXin instance;

    private Crop crop;
    private Map<String, Request> requests = new HashMap<String, Request>();

    private WeiXin() {
        XmlEntityLoader loader = DefaultXmlEntityLoader.getInstance();
        List<Crop> crops = loader.load(Crop.class);
        crop = crops.get(0);

        List<Request> requestList = loader.load(Request.class);
        for (Request request : requestList) {
            requests.put(request.getUri(), request);
        }
    }

    public static WeiXin getInstance() {
        if (instance == null) {
            synchronized (WeiXin.class) {
                if (instance == null) {
                    instance = new WeiXin();
                }
            }
        }
        return instance;
    }

    public Crop getCrop() {
        return crop;
    }

    public Request getRequest(String uri) {
        return requests.get(uri);
    }

}
