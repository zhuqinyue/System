//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.company.system.dao.UserDao;
import com.company.system.entity.SysUser;
import com.company.system.exception.ServiceExcetion;
import com.company.system.service.UserService;
import com.company.system.utlis.CommonUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserserviceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public UserserviceImpl() {
    }

    public Boolean registeruser(SysUser sysuser, HttpServletRequest request, HttpServletResponse response) {
        String username = sysuser.getUsername();
        String password = sysuser.getPassword();
        if(!username.isEmpty() && !"".equals(username)) {
            if(!password.isEmpty() && !"".equals(password)) {
                SysUser user = new SysUser();
                user.setUsername(sysuser.getUsername());
                List sysUsers = this.userDao.selectList(new QueryWrapper(user));
                if(sysUsers.size() > 0) {
                    throw new ServiceExcetion("用户名已经被占用");
                } else {
                    user.setPassword(DigestUtils.md5DigestAsHex(sysuser.getPassword().getBytes()));
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
                    user.setCreateddate(sdf.format(new Date()));
                    user.setUpdatedate(sdf.format(new Date()));
                    int insert = this.userDao.insert(user);
                    if(insert == 1) {
                        String token = CommonUtils.getToken(username);
                        HttpSession session = request.getSession();
                        session.setAttribute(token, user.getUsername());
                        session.setMaxInactiveInterval(86400);
                        CommonUtils.addCookie(response, "USERKEY", token, 86400);
                        return Boolean.valueOf(true);
                    } else {
                        return Boolean.valueOf(false);
                    }
                }
            } else {
                throw new ServiceExcetion("密码不能为空");
            }
        } else {
            throw new ServiceExcetion("用户名不能为空");
        }
    }

    public Boolean login(SysUser user, HttpServletRequest request, HttpServletResponse response) {
        QueryWrapper sysUserQueryWrapper = new QueryWrapper();
        sysUserQueryWrapper.eq("username", user.getUsername());
        SysUser kuuser = (SysUser)this.userDao.selectOne(sysUserQueryWrapper);
        if(kuuser != null && !"".equals(kuuser)) {
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
            SysUser sysUser = (SysUser)this.userDao.selectOne((Wrapper)((QueryWrapper)(new QueryWrapper()).eq("username", user.getUsername())).eq("password", user.getPassword()));
            if(sysUser != null && !"".equals(sysUser)) {
                String token = CommonUtils.getToken(sysUser.getUsername());
                HttpSession session = request.getSession();
                session.setAttribute(token, sysUser.getUsername());
                session.setMaxInactiveInterval(86400);
                CommonUtils.addCookie(response, "USERKEY", token, 86400);
                return Boolean.valueOf(true);
            }
        }

        return Boolean.valueOf(false);
    }
}
