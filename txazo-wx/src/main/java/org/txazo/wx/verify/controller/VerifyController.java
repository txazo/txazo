package org.txazo.wx.verify.controller;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * VerifyController
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 03.06.2015
 */
@Controller
@RequestMapping("/verify")
public class VerifyController {

    private static String sToken = "idvstxzgnvNR94XWdFdnC1tbt7vV";
    private static String sCorpID = "wxb6d9c5e36e0501f8";
    private static String sEncodingAESKey = "NwEgnXH97SmWo2yXhSRFz79t9eNfS6yEXkEDHKFzB9q";

    private static WXBizMsgCrypt wxcpt = null;

    static {
        try {
            wxcpt = new WXBizMsgCrypt(sToken, sEncodingAESKey, sCorpID);
        } catch (AesException e) {
            throw new RuntimeException("VerifyController init failed");
        }
    }

    @RequestMapping("/verify.wx")
    public void verify(@RequestParam(value = "msg_signature", required = true) String msg_signature,
                       @RequestParam(value = "timestamp", required = true) String timestamp,
                       @RequestParam(value = "nonce", required = true) String nonce,
                       @RequestParam(value = "echostr", required = true) String echostr,
                       HttpServletResponse response) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
            String sEchoStr = wxcpt.VerifyURL(msg_signature, timestamp, nonce, echostr);
            out.print(sEchoStr);
        } catch (AesException | IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(out);
        }
    }

}
