//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.intercepors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    public LoginInterceptor() {
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();

        try {
            if(cookies != null && cookies.length > 0) {
                Cookie[] e = cookies;
                int var6 = cookies.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    Cookie cookie = e[var7];
                    if("USERKEY".equals(cookie.getName())) {
                        String value = cookie.getValue();
                        if(!"".equals(value) && !value.isEmpty() && value != null) {
                            HttpSession session = request.getSession();
                            String username = (String)session.getAttribute(value);
                            if(username != null && !username.isEmpty()) {
                                return true;
                            }

                            response.sendRedirect("/desk/loginview");
                            return false;
                        }
                    }
                }
            }

            response.sendRedirect("/desk/loginview");
            return false;
        } catch (Exception var12) {
            var12.printStackTrace();
            return false;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
