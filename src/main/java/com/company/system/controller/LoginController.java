//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.controller;

import com.company.system.entity.SysUser;
import com.company.system.service.UserService;
import com.company.system.vo.SysResult;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/desk"})
public class LoginController {
    @Autowired
    private UserService userService;

    public LoginController() {
    }

    @RequestMapping({"/loginview"})
    public String loginview() {
        return "/view/login.html";
    }

    @PostMapping({"/register"})
    @ResponseBody
    public SysResult register(SysUser user, HttpServletRequest request, HttpServletResponse response) {
        Boolean registeruser = this.userService.registeruser(user, request, response);
        return registeruser.booleanValue()?SysResult.build(Integer.valueOf(0), "注册成功"):SysResult.build(Integer.valueOf(1), "注册失败,出错了");
    }

    @PostMapping({"/login"})
    @ResponseBody
    public SysResult login(SysUser user, HttpServletRequest request, HttpServletResponse response) {
        return this.userService.login(user, request, response).booleanValue()?SysResult.oK():SysResult.build(Integer.valueOf(1), "账号或者密码错误");
    }

    @RequestMapping({"logout"})
    @ResponseBody
    public SysResult logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.invalidate();
        return SysResult.oK();
    }
}
