//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.Quartz;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.company.system.dao.CaseDao;
import com.company.system.dao.NewsDao;
import com.company.system.entity.SysCase;
import com.company.system.entity.SysNews;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    @Autowired
    private CaseDao caseDao;
    @Autowired
    private NewsDao newsDao;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public ScheduledTasks() {
    }

    @Scheduled(
            cron = "0 0 3 * * ? "
    )
    public void UpdateCaseAndNews() {
        System.out.println("================开始===========");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List sysCases = this.caseDao.selectList((Wrapper)null);
        List sysNews = this.newsDao.selectList((Wrapper)null);
        Date newtime = new Date();

        try {
            Iterator e = sysNews.iterator();

            String caseendtime;
            Date endtime;
            while(e.hasNext()) {
                SysNews sysCase = (SysNews)e.next();
                caseendtime = sysCase.getEndtime();
                endtime = sdf.parse(caseendtime);
                if(newtime.getTime() > endtime.getTime()) {
                    SysNews Case = new SysNews();
                    if("已发布".equals(sysCase.getZhuangtai())) {
                        Case.setZhuangtai("未发布");
                        this.newsDao.update(Case, (Wrapper)(new QueryWrapper()).eq("newsid", sysCase.getNewsid()));
                    }
                }
            }

            e = sysCases.iterator();

            while(e.hasNext()) {
                SysCase sysCase1 = (SysCase)e.next();
                caseendtime = sysCase1.getCaseendtime();
                endtime = sdf.parse(caseendtime);
                if(newtime.getTime() > endtime.getTime()) {
                    SysCase Case1 = new SysCase();
                    if("已发布".equals(sysCase1.getCasezhuangtai())) {
                        Case1.setCasezhuangtai("未发布");
                        this.caseDao.update(Case1, (Wrapper)(new QueryWrapper()).eq("caseid", sysCase1.getCaseid()));
                    }
                }
            }
        } catch (Exception var10) {
            var10.printStackTrace();
        }

    }
}
