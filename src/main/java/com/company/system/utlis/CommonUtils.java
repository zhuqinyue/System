//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.utlis;

import java.util.Date;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.DigestUtils;

public class CommonUtils {
    public CommonUtils() {
    }

    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        if(maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }

        response.addCookie(cookie);
    }

    public static String getToken(String username) {
        Date date = new Date();
        String MD5 = date + username;
        String s = DigestUtils.md5DigestAsHex(MD5.getBytes());
        return s;
    }
}
