//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.company.system.entity.SysCase;
import com.company.system.entity.SysNews;
import com.company.system.entity.indexcontent;
import com.company.system.service.CaseService;
import com.company.system.service.CrawLing;
import com.company.system.service.NewsService;
import com.company.system.utlis.MailUtils;
import com.company.system.vo.SysResult;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"desk"})
public class DeskController {
    @Autowired
    private MailUtils mailUtils;
    @Autowired
    private CaseService caseService;
    @Autowired
    private CrawLing crawLing;
    @Autowired
    private NewsService newsService;
    private final String CASES = "cases";
    private final String NEWS = "news";

    public DeskController() {
    }

    @PostMapping({"findOneNewsBodyById"})
    @ResponseBody
    public SysResult findOneNewsBodyById(int newsid, String type) {
        if(type != null && "cases".equals(type)) {
            SysCase news1 = this.caseService.findCaseBycaseID(String.valueOf(newsid));
            return news1 != null && !"".equals(news1)?SysResult.oK(news1):SysResult.build(Integer.valueOf(1), "没有查询到记录哦");
        } else if(type != null && "news".equals(type)) {
            SysNews news = this.newsService.findOneNewsById(newsid);
            return news != null && !"news".equals(news)?SysResult.oK(news):SysResult.build(Integer.valueOf(1), "没有查询到记录哦");
        } else {
            return SysResult.build(Integer.valueOf(1), "出现错误,请联系管理员");
        }
    }

    @RequestMapping({"getbodypage"})
    public String getbodypage() {
        return "/view/desk/BodyData.html";
    }

    @RequestMapping({"getpageindex.html"})
    public String getpageindex() {
        return "/view/desk/shouye.html";
    }

    @RequestMapping({"getpageexample"})
    public String getpageexample() {
        return "/view/desk/example.html";
    }

    @RequestMapping({"getpagenews.html"})
    public String getpagenews() {
        return "/view/desk/news.html";
    }

    @RequestMapping({"getpagenewsdetail.html"})
    public ModelAndView getPageNewsDetail(String newsid) {
        ModelAndView mv = new ModelAndView("/WEB-INF/news-detail.jsp");
        SysNews newsByNewsId = this.newsService.findNewsByNewsID(newsid);
        mv.addObject("keywords", newsByNewsId.getSynopsis());
        mv.addObject("description", newsByNewsId.getSynopsis());
        mv.addObject("title", newsByNewsId.getNewstitle());
        return mv;
    }

    @RequestMapping({"getpagecasesdetail"})
    public String getpagecasesdetail() {
        return "/view/desk/cases-detail.html";
    }

    @RequestMapping({"demo"})
    public String dd() {
        return "Demo";
    }

    @RequestMapping({"getcases"})
    @ResponseBody
    public SysResult getcases() {
        IPage page = this.caseService.page(Integer.valueOf(0), Integer.valueOf(5), "", "", "", "");
        List records = page.getRecords();
        return records != null && records.size() > 0?SysResult.oK(records):SysResult.build(Integer.valueOf(1), "查询案例数据出错");
    }

    @RequestMapping({"getnews"})
    @ResponseBody
    public SysResult getnews(String type, String classify) {
        List list = null;
        if(type != null && type.equals("news")) {
            list = this.newsService.findFiveNews();
        } else if(type != null && type.equals("tuijian")) {
            list = this.newsService.findtuijians();
        } else if(type != null && type.equals("four")) {
            list = this.newsService.findFourNews();
        }

        return list != null && list.size() > 0?SysResult.oK(list):SysResult.build(Integer.valueOf(1), "查询新闻数据失败");
    }

    @RequestMapping({"getallnews"})
    @ResponseBody
    public SysResult getAllNews(String classify, Integer currentpage, Integer pagesize) {
        if(classify != null && !classify.equals("")) {
            IPage page = this.newsService.page(currentpage.intValue(), pagesize.intValue(), (String)null, (String)null, (String)null, Integer.valueOf(classify));
            return SysResult.build(Integer.valueOf(0), "OK", page);
        } else {
            return SysResult.build(Integer.valueOf(1), "查询新闻数据失败");
        }
    }

    @RequestMapping({"getallcases"})
    @ResponseBody
    public SysResult getAllCases(Integer currentpage, Integer pagesize) {
        IPage page = this.caseService.page(currentpage, pagesize, (String)null, (String)null, (String)null, "isdesk");
        return page != null && page.getRecords().size() > 0?SysResult.oK(page):SysResult.build(Integer.valueOf(1), "查询新闻数据失败");
    }

    @RequestMapping("addPV")
    @ResponseBody
    public SysResult addPv(String id, String type) {
        Boolean flag;
        if(id != null && !id.equals("") && type != null && !type.equals("")) {
            if(type.equals("news")) {
                flag = newsService.addPV(id);
            }

            if(type.equals("cases")) {
                this.caseService.addPV(id);
            }
        }
            if(false){
                return SysResult.oK();
            }else{
                return SysResult.build(1,"错误");
            }
    }

    @RequestMapping({"sendMail"})
    @ResponseBody
    public SysResult sendMail(String name, String tel, String content) {
        Integer res = this.mailUtils.sendMail(name, tel, content);
        return res != null && res.intValue() != 0?(res.intValue() == 1?SysResult.oK():SysResult.build(Integer.valueOf(0), "发送邮件失败", (Object)null)):SysResult.build(Integer.valueOf(0), "发送邮件失败", (Object)null);
    }

    @RequestMapping({"sss"})
    public void sss() {
        this.crawLing.qingGua();
    }

    @RequestMapping({"findimgs"})
    @ResponseBody
    public SysResult findimgs() {
        indexcontent res = this.newsService.findimgs();
        return SysResult.oK(res);
    }
}
