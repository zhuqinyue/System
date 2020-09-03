//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.system.dao.DemoInterface;
import com.company.system.entity.User;
import com.company.system.service.DemoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoInterface demoInterface;

    public DemoServiceImpl() {
    }

    public List<User> getAllData() {
        return this.demoInterface.selectList((Wrapper)null);
    }

    public IPage<User> page(int currentPage, int pageSize) {
        Page page = new Page((long)currentPage, (long)pageSize);
        IPage page1 = this.demoInterface.selectPage(page, (Wrapper)null);
        return page1;
    }

    public List<User> getUserbyName(String username) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name", username);
        return this.demoInterface.selectList(wrapper);
    }
}
