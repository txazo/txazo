package org.txazo.weixin.develop.jsapi;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.txazo.weixin.WeiXinHolder;

/**
 * JsApiUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 02.07.2015
 */
public abstract class JsApiUtils extends WeiXinHolder {

    private static TicketHolder ticketHolder = TicketHolder.getInstance();

    static String getTicket() {
        return ticketHolder.getTicket();
    }

    static Ticket requestTicket() {
        String json = executor.executeRequest(URI_GET_JSAPI_TICKET);
        return parseResult(json, Ticket.class);
    }

    public static JsConfig generateJsConfig(String url) {
        String ticket = getTicket();
        JsConfig jsConfig = new JsConfig();
        jsConfig.setAppId(weiXin.getCrop().getCorpid());
        jsConfig.setTimestamp(System.currentTimeMillis());
        jsConfig.setNonceStr(DigestUtils.md5Hex(ticket));

        StringBuilder sb = new StringBuilder();
        sb.append("jsapi_ticket=").append(ticket);
        sb.append("&noncestr=").append(jsConfig.getNonceStr());
        sb.append("&timestamp=").append(jsConfig.getTimestamp());
        sb.append("&url=").append(url);

        String signature = sha1(sb.toString());
        jsConfig.setSignature(signature);

        return jsConfig;
    }

    private static String sha1(String data) {
        return Hex.encodeHexString(DigestUtils.getSha1Digest().digest(data.getBytes()));
    }

}
