package org.txazo.weixin;

import org.apache.commons.collections4.CollectionUtils;
import org.txazo.weixin.bean.Crop;
import org.txazo.weixin.bean.Verify;
import org.txazo.weixin.http.Request;
import org.txazo.weixin.xml.DefaultXmlEntityLoader;
import org.txazo.weixin.xml.XmlEntityLoader;

import java.util.*;

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
    private Set<Verify> verifys = new HashSet<Verify>();
    private Map<String, Request> requests = new HashMap<String, Request>();

    private WeiXin() {
        XmlEntityLoader loader = DefaultXmlEntityLoader.getInstance();
        List<Crop> crops = loader.load(Crop.class);
        crop = crops.get(0);

        List<Verify> verifyList = loader.load(Verify.class);
        if (CollectionUtils.isNotEmpty(verifyList)) {
            for (Verify verify : verifyList) {
                verifys.add(verify);
            }
        }

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

    public Set<Verify> getVerifys() {
        return verifys;
    }

    public Request getRequest(String uri) {
        return requests.get(uri);
    }

}
