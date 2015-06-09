package org.txazo.weixin.develop.verify;

import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import org.txazo.weixin.WeiXinUtils;
import org.txazo.weixin.bean.Verify;

import java.util.Set;

/**
 * VerifyUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 09.06.2015
 */
public class VerifyUtils extends WeiXinUtils {

    public static String verifyURL(String msg_signature, String timestamp, String nonce, String echostr) {
        WXBizMsgCrypt wxcpt = null;
        Set<Verify> verifys = weiXin.getVerifys();
        for (Verify verify : verifys) {
            try {
                wxcpt = new WXBizMsgCrypt(verify.getStoken(), verify.getSencodingaeskey(), weiXin.getCrop().getCorpid());
                return wxcpt.VerifyURL(msg_signature, timestamp, nonce, echostr);
            } catch (Throwable t) {
            }
        }
        return null;
    }


}
