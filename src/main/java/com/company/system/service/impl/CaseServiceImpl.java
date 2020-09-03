//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.system.dao.CaseDao;
import com.company.system.entity.SysCase;
import com.company.system.exception.ServiceExcetion;
import com.company.system.service.CaseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class CaseServiceImpl implements CaseService {
    @Autowired
    private CaseDao caseDao;
    @Autowired
    private StringRedisTemplate redisTemplate;

    public CaseServiceImpl() {
    }

    public boolean addOneCase(SysCase sysCase) {
        if(sysCase.getCasestarttime() != null && !sysCase.getCasestarttime().isEmpty() && sysCase.getCaseendtime() != null && !sysCase.getCaseendtime().isEmpty()) {
            String Starttime = sysCase.getCasestarttime().replace("-", "");
            String Endtime = sysCase.getCaseendtime().replace("-", "");
            if(!Starttime.isEmpty() && !Endtime.isEmpty()) {
                int Starttimeint = Integer.parseInt(Starttime);
                int Endtimeint = Integer.parseInt(Endtime);
                if(Starttimeint > Endtimeint) {
                    throw new ServiceExcetion("开始时间不能大于结束时间");
                }
            }

            if(sysCase == null) {
                throw new ServiceExcetion("保存出错,请联系管理员");
            } else if(sysCase.getCasetlt() != null && !sysCase.getCasetlt().equals("")) {
                if(sysCase.getCasetarget() != null && !sysCase.getCasetarget().equals("")) {
                    if(sysCase.getCasebody() != null && !sysCase.getCasebody().equals("")) {
                        if(sysCase.getCaseimgsrc().equals("/img/upload-3.png")) {
                            throw new ServiceExcetion("请上传案例展示图片");
                        } else {
                            sysCase.setCasezhuangtai("已发布");
                            sysCase.setCaseiszancun("0");
                            sysCase.setCasecreattime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()).toString());
                            sysCase.setCaseupdatetime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()).toString());
                            return this.caseDao.insert(sysCase) == 1;
                        }
                    } else {
                        throw new ServiceExcetion("请输入案例主体内容");
                    }
                } else {
                    throw new ServiceExcetion("请输入案例所属公司");
                }
            } else {
                throw new ServiceExcetion("请输入案例标题");
            }
        } else {
            throw new ServiceExcetion("请填写时间");
        }
    }

    public IPage<SysCase> page(Integer currentpage, Integer pagesize, String casetlt, String starttime, String endtime, String isdesk) {
        if(starttime != null && !StringUtils.isEmpty(starttime) && endtime != null && !StringUtils.isEmpty(endtime) && Integer.parseInt(starttime.replace("-", "")) > Integer.parseInt(endtime.replace("-", ""))) {
            throw new ServiceExcetion("开始时间不能大于结束时间");
        } else {
            QueryWrapper sysCaseQueryWrapper = new QueryWrapper();
            if(casetlt != null && !StringUtils.isEmpty(casetlt)) {
                sysCaseQueryWrapper.like("casetlt", casetlt);
            }

            if(starttime != null && !StringUtils.isEmpty(starttime)) {
                sysCaseQueryWrapper.ge("casestarttime", starttime);
            }

            if(endtime != null && !StringUtils.isEmpty(endtime)) {
                endtime = endtime + " 23:59:59";
                sysCaseQueryWrapper.le("casestarttime", endtime);
            }

            if(isdesk != null && isdesk == "isdesk") {
                sysCaseQueryWrapper.eq("casezhuangtai", "已发布");
            }

//            sysCaseQueryWrapper.select(SysCase.class, (info) -> {
//                return !info.getColumn().equals("casebody");
//            });
            sysCaseQueryWrapper.orderByDesc(new String[]{"casecreattime"});
            Page page = new Page((long)currentpage.intValue(), (long)pagesize.intValue());
            IPage page1 = this.caseDao.selectPage(page, sysCaseQueryWrapper);
            return page1;
        }
    }

    @Transactional
    public boolean deletecasebyid(String caseid) {
        return caseid != null && !caseid.isEmpty() && !caseid.equals("0")?this.caseDao.deleteById(Integer.valueOf(Integer.parseInt(caseid))) == 1:false;
    }

    @Transactional
    public boolean deleteList(List<String> datalist) {
        if(datalist != null && datalist.size() > 0) {
            return this.caseDao.deleteBatchIds(datalist) > 0;
        } else {
            throw new ServiceExcetion("请选择要删除的记录");
        }
    }

    @Transactional
    public boolean updatezhuangtai(int caseid, String zhuangtai) {
        if(caseid == 0) {
            throw new ServiceExcetion("新闻id不能为空");
        } else if(zhuangtai != null && !zhuangtai.equals("")) {
            SysCase sysCase = new SysCase();
            sysCase.setCaseid(Integer.valueOf(caseid));
            sysCase.setCasezhuangtai(zhuangtai);
            return this.caseDao.updateById(sysCase) > 0;
        } else {
            throw new ServiceExcetion("新闻状态不能为空");
        }
    }

    public boolean zancun(SysCase cased, String type) {
        if(cased.getCasetlt() != null && !cased.getCasetlt().equals("")) {
            cased.setCaseiszancun("1");
            cased.setCasezhuangtai("未发布");
            cased.setCaseupdatetime((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()).toString());
            return type != null && type.equals("add")?this.caseDao.insert(cased) > 0:(type != null && type.equals("update")?this.caseDao.updateById(cased) > 0:false);
        } else {
            throw new ServiceExcetion("必须填写标题");
        }
    }

    public SysCase findCaseBycaseID(String caseid) {
        long l1 = System.currentTimeMillis();
        if(caseid != null && !caseid.isEmpty()) {
            String s = (String)this.redisTemplate.opsForValue().get("cases" + caseid);
            SysCase sysCase;
            if(s != null && !s.isEmpty()) {
                try {
                    sysCase = (SysCase)(new ObjectMapper()).readValue(s, SysCase.class);
                    return sysCase;
                } catch (JsonProcessingException var8) {
                    System.out.println("=======json转化失败===========");
                    var8.printStackTrace();
                }
            }

            sysCase = (SysCase)this.caseDao.selectById(caseid);
            long l2 = System.currentTimeMillis();
            System.out.println("执行时间" + (l2 - l1));
            if(sysCase != null) {
                return sysCase;
            } else {
                throw new ServiceExcetion("记录可能不存在");
            }
        } else {
            return null;
        }
    }

    public boolean updateCase(SysCase cases) {
        if(this.deletecasebyid(cases.getCaseid().toString())) {
            cases.setCaseid((Integer)null);
            return this.addOneCase(cases);
        } else {
            return false;
        }
    }

    public List<SysCase> findFiveCase() {
        List list = this.caseDao.findFiveCase((new SimpleDateFormat("yyyy-MM-dd")).format(new Date()).toString());
        return list.size() > 0?list:null;
    }

    public List<SysCase> findAllCase() {
        List list = this.caseDao.findAllCases((new SimpleDateFormat("yyyy-MM-dd")).format(new Date()).toString());
        if(list != null && list.size() > 0) {
            return list;
        } else {
            throw new ServiceExcetion("记录可能不存在");
        }
    }

    public void addPV(String id) {
        SysCase sysCase = (SysCase)this.caseDao.selectOne((Wrapper)(new QueryWrapper()).eq("caseid", id));
        Integer casepv = sysCase.getCasepv();
        if(casepv == null) {
            casepv = Integer.valueOf(1);
        }

        this.caseDao.updatePVbyID(id, casepv.intValue() + 1);
    }
}
