package org.txazo.weixin.develop.verify;

import org.txazo.weixin.annotation.EntityPath;
import org.txazo.weixin.xml.XmlEntity;

/**
 * Verify
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 09.06.2015
 */
@EntityPath(path = "verifys.verify")
public class Verify implements XmlEntity {

    @EntityPath(path = "verifys.verify.stoken")
    private String stoken;
    @EntityPath(path = "verifys.verify.sencodingaeskey")
    private String sencodingaeskey;

    public Verify() {
    }

    public String getStoken() {
        return stoken;
    }

    public String getSencodingaeskey() {
        return sencodingaeskey;
    }

    @Override
    public int hashCode() {
        return (stoken == null ? 0 : stoken.hashCode()) + (sencodingaeskey == null ? 0 : sencodingaeskey.hashCode()) * 31;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Verify) {
            Verify other = (Verify) obj;
            return (stoken == null ? other.getStoken() == null : stoken.equals(other.getStoken()))
                    && (sencodingaeskey == null ? other.getSencodingaeskey() == null : sencodingaeskey.equals(other.getSencodingaeskey()));
        }
        return false;
    }

}
