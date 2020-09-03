//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.company.system.dao.CaseDao;
import com.company.system.dao.NewsDao;
import com.company.system.entity.SysCase;
import com.company.system.entity.SysNews;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class TongBuBody implements CommandLineRunner {
    @Autowired
    private CaseDao caseDao;
    @Autowired
    private NewsDao newsDao;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    public static final Logger LOGGER = LogManager.getLogger("");

    public TongBuBody() {
    }

    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        try {
            List e = this.caseDao.selectList((Wrapper)null);
            List sysNews = this.newsDao.selectList((Wrapper)null);
            Iterator var5 = e.iterator();

            while(var5.hasNext()) {
                SysCase news = (SysCase)var5.next();
                this.stringRedisTemplate.opsForValue().set("cases" + news.getCaseid(), mapper.writeValueAsString(news));
            }

            var5 = sysNews.iterator();

            while(var5.hasNext()) {
                SysNews news1 = (SysNews)var5.next();
                this.stringRedisTemplate.opsForValue().set("news" + news1.getNewsid(), mapper.writeValueAsString(news1));
            }

            LOGGER.debug("===========================初始化缓存数据成功===========================");
        } catch (Exception var7) {
            var7.printStackTrace();
            LOGGER.error("===========================初始化缓存数据失败===========================");
        }

    }
}
