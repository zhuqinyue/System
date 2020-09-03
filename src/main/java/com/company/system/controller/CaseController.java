//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.company.system.entity.SysCase;
import com.company.system.service.CaseService;
import com.company.system.vo.SysResult;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"case"})
public class CaseController {
    @Autowired
    private CaseService caseService;

    public CaseController() {
    }

    @RequestMapping({"addcase"})
    public String addsucess() {
        return "/view/addcase.html";
    }

    @PostMapping({"subcase"})
    @ResponseBody
    public SysResult subcase(SysCase sysCase) {
        System.out.println("案例==" + sysCase);
        return this.caseService.addOneCase(sysCase)?SysResult.oK():SysResult.build(Integer.valueOf(1), "保存失败了");
    }

    @RequestMapping({"getpage"})
    @ResponseBody
    public SysResult getPage(Integer currentpage, Integer pagesize, String casetlt, String startime, String endtiem) {
        if(currentpage != null && pagesize != null && currentpage.intValue() > 0 && pagesize.intValue() > 0) {
            IPage page = this.caseService.page(currentpage, pagesize, casetlt, startime, endtiem, (String)null);
            return SysResult.oK(page);
        } else {
            return SysResult.build(Integer.valueOf(1), "查询失败了,请联系管理员");
        }
    }

    @RequestMapping({"deletecasebyid"})
    @ResponseBody
    public SysResult deletenewsbyid(String caseid) {
        return this.caseService.deletecasebyid(caseid)?SysResult.oK():SysResult.build(Integer.valueOf(1), "删除失败,数据已经回滚,请联系管理员");
    }

    @RequestMapping({"/deleteList"})
    @ResponseBody
    public SysResult deleteList(@RequestParam(value = "datalist[]",required = false) List<String> datalist) {
        return this.caseService.deleteList(datalist)?SysResult.oK():SysResult.build(Integer.valueOf(1), "删除失败,请联系管理员");
    }

    @RequestMapping({"updatezhuangtai"})
    @ResponseBody
    public SysResult updatezhuangtai(int caseid, String zhuangtai) {
        return this.caseService.updatezhuangtai(caseid, zhuangtai)?SysResult.oK():SysResult.build(Integer.valueOf(1), "修改失败");
    }

    @RequestMapping({"zancun"})
    @ResponseBody
    public SysResult zancun(SysCase cased, String type) {
        return this.caseService.zancun(cased, type)?SysResult.build(Integer.valueOf(0), "暂存成功！"):SysResult.build(Integer.valueOf(1), "保存失败,请联系管理员");
    }

    @RequestMapping({"findCaseBycaseID"})
    @ResponseBody
    public SysResult findCaseByCaseId(String caseid) {
        SysCase sysCase = this.caseService.findCaseBycaseID(caseid);
        return sysCase != null?SysResult.oK(sysCase):SysResult.build(Integer.valueOf(1), "查询失败了,请联系管理员");
    }

    @RequestMapping({"upcase"})
    @ResponseBody
    public SysResult updateNews(SysCase cases) {
        return cases != null && this.caseService.updateCase(cases)?SysResult.oK("更新成功"):SysResult.build(Integer.valueOf(1), "更新失败");
    }

    @RequestMapping({"updatecase"})
    public String updatecase() {
        return "/view/updatecase.html";
    }
}
