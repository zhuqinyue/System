//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.service;

import com.company.system.entity.SysUser;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    Boolean registeruser(SysUser var1, HttpServletRequest var2, HttpServletResponse var3);

    Boolean login(SysUser var1, HttpServletRequest var2, HttpServletResponse var3);
}
