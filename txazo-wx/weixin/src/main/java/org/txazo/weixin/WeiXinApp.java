package org.txazo.weixin;

import org.txazo.weixin.bean.Request;
import org.txazo.weixin.xml.DefaultXmlEntityLoader;
import org.txazo.weixin.xml.XmlEntityLoader;

import java.util.List;

/**
 * WeiXinApp
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
public class WeiXinApp {

    public static void main(String[] args) {
        XmlEntityLoader loader = DefaultXmlEntityLoader.getInstance();
        List<Request> requests = loader.load(Request.class);
    }

}
