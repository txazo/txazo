package org.txazo.wx.app.common.util;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CookieUtils
 *
 * @author txazo
 * @email txazo1218@163.com
 * @since 30.06.2015
 */
public abstract class CookieUtils {

    private static final int DefaultMaxAge = 2592000;

    public static String getCookieValue(String key, HttpServletRequest request) {
        if (request == null) {
            return StringUtils.EMPTY;
        }
        Cookie[] cookies = request.getCookies();
        if (ArrayUtils.isNotEmpty(cookies)) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(key)) {
                    return cookie.getValue();
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public static void setCookie(HttpServletResponse response, String cookieName, String cookieValue) {
        setCookie(response, cookieName, cookieValue, null, null, DefaultMaxAge);
    }

    public static void setCookie(HttpServletResponse response, String cookieName, String cookieValue, int maxAge) {
        setCookie(response, cookieName, cookieValue, null, null, maxAge);
    }

    public static void setCookie(HttpServletResponse response, String cookieName, String cookieValue, String domain, String path) {
        setCookie(response, cookieName, cookieValue, domain, path, DefaultMaxAge);
    }

    public static void setCookie(HttpServletResponse response, String cookieName, String cookieValue, String domain, String path, int maxAge) {
        if (response == null || StringUtils.isBlank(cookieName)) {
            return;
        }

        Cookie cookie = new Cookie(cookieName, cookieValue);
        if (StringUtils.isNotBlank(domain)) {
            cookie.setDomain(domain);
        }
        cookie.setPath(StringUtils.isNotBlank(path) ? path : "/");
        cookie.setMaxAge(maxAge >= 0 ? maxAge : -1);

        response.addCookie(cookie);
    }

}
