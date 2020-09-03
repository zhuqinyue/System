//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.company.system.entity.User;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface DemoService {
    List<User> getAllData();

    IPage<User> page(int var1, int var2);

    List<User> getUserbyName(String var1);
}
