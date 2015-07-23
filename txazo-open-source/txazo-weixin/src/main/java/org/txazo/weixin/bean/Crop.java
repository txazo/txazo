package org.txazo.weixin.bean;

import org.txazo.weixin.annotation.EntityPath;
import org.txazo.weixin.xml.XmlEntity;

/**
 * Crop
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 05.06.2015
 */
@EntityPath(path = "crop")
public class Crop implements XmlEntity {

    @EntityPath(path = "crop.corpid")
    private String corpid;
    @EntityPath(path = "crop.corpsecret")
    private String corpsecret;

    public Crop() {
    }

    public String getCorpid() {
        return corpid;
    }

    public String getCorpsecret() {
        return corpsecret;
    }

}
